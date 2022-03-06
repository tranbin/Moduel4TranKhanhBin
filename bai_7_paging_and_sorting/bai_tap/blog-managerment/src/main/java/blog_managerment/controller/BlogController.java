package blog_managerment.controller;

import blog_managerment.model.Blog;
import blog_managerment.model.Category;
import blog_managerment.service.impl.BlogServiceImpl;
import blog_managerment.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private BlogServiceImpl blogService;

    @Autowired
    private CategoryServiceImpl categoryService;


    @GetMapping("/blog")
    public ModelAndView getIndex(@PageableDefault(size = 3) Pageable pageable) {
        return new ModelAndView("blog/list", "blogs", blogService.findAll(pageable));
    }

    //

    @GetMapping("/create-blog")
    public ModelAndView showCreateForm(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return new ModelAndView("/blog/createBlog", "blog", new Blog());
    }

    @PostMapping("/create-blog")
    public ModelAndView saveMusic(@ModelAttribute("blog") Blog blog) {
        blogService.saveBlog(blog);
        ModelAndView modelAndView = new ModelAndView("/blog/createBlog");
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("message", "New blog created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-blog/{id}")
    public ModelAndView showEditForm(@PathVariable int id, Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        Blog blog = blogService.findBlogById(id);
        if (blog != null) {
            ModelAndView modelAndView = new ModelAndView("blog/edit");
            modelAndView.addObject("blog", blog);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-blog")
    public ModelAndView updateBlog(@ModelAttribute("blog") Blog blog) {
        blogService.saveBlog(blog);
        ModelAndView modelAndView = new ModelAndView("blog/edit");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("message", "Blog updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-blog/{id}")
    public ModelAndView showDeleteForm(@PathVariable int id, Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        Blog blog = blogService.findBlogById(id);
        if (blog != null) {
            ModelAndView modelAndView = new ModelAndView("blog/delete");
            modelAndView.addObject("blog", blog);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-blog")
    public String deleteBlog(@ModelAttribute("blog") Blog blog) {
        blogService.deleteBlog(blog.getId());
        return "blog/list";
    }

    @GetMapping("/view-blog/{id}")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findBlogById(id));
        return "blog/view";
    }

    @GetMapping("/search-blog")
    public String searchByContent(@RequestParam("searchContent") String content,Pageable pageable, Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        Page<Blog> blogs = blogService.findByContent(content,pageable);
        model.addAttribute("blogs", blogs);
        return "blog/list";

    }
}
