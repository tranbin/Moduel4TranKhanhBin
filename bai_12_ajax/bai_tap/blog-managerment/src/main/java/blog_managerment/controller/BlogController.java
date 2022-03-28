package blog_managerment.controller;

import blog_managerment.dto.BlogDTO;
import blog_managerment.model.Blog;
import blog_managerment.service.impl.BlogServiceImpl;
import blog_managerment.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogServiceImpl blogService;

    @Autowired
    private CategoryServiceImpl categoryService;


    @GetMapping("/list")
    private ModelAndView getPage(Model model) {
        model.addAttribute("categorys", categoryService.findAll());
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("blogs", blogService.findAll());
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @GetMapping
    public ResponseEntity<List<Blog>> getAll() {
        return new ResponseEntity<>(blogService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BlogDTO> saveBlog(@RequestBody BlogDTO blogDTO) {
        blogService.saveBlogDTO(blogDTO);
        return new ResponseEntity<>(blogDTO, HttpStatus.CREATED);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Blog>> seachBlog(@RequestParam String name) {
        List<Blog> list = blogService.findByName(name);
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/load")
    public ResponseEntity<List<Blog>> load(Integer Count) {
        List<Blog> blogList = blogService.selectLimit(Count + 2);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }


}
