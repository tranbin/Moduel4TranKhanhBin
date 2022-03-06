package blog_managerment.controller;

import blog_managerment.model.Blog;
import blog_managerment.model.Category;
import blog_managerment.service.impl.BlogServiceImpl;
import blog_managerment.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private CategoryServiceImpl categoryService;

    @Autowired
    private BlogServiceImpl blogService;

    @GetMapping("/category")
    public ModelAndView getPageHome(@PageableDefault(size = 3)Pageable pageable) {
        return new ModelAndView("category/index", "categorys", categoryService.findAll(pageable));
    }

    @GetMapping("/create-category")
    public ModelAndView showCreateForm() {
        return new ModelAndView("category/create", "category", new Category());
    }

    @PostMapping("/create-category")
    public ModelAndView saveCategory(@ModelAttribute("category") Category category) {
        categoryService.saveCategory(category);
        ModelAndView modelAndView = new ModelAndView("category/create");
        modelAndView.addObject("category", new Category());
        modelAndView.addObject("message", "New category create successfully");
        return modelAndView;
    }

    @GetMapping("/view-category/{id}")
    public String view(@PathVariable int id, Model model) {
        List<Blog> blogList = blogService.findAllBlogById(id);
        model.addAttribute("blogs", blogList);
        model.addAttribute("id", id);
        return "blog/list";
    }

    @GetMapping("/delete-category/{id}")
    public ModelAndView showDeleteForm(@PathVariable int id, Model model) {
        List<Blog> blogList = blogService.findAllBlogById(id);
        model.addAttribute("blogs", blogList);
        Category category = categoryService.findCategoryById(id);
        if (category != null) {
            ModelAndView modelAndView = new ModelAndView("category/delete");
            modelAndView.addObject("category", category);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }
    @PostMapping("/delete-category")
    public String deleteCategory(@ModelAttribute("category") Category category){
        categoryService.deleteCategory(category.getId());
        return "category/index";
    }

}
