package com.example.blog_management.controller;

import com.example.blog_management.model.Blog;
import com.example.blog_management.model.Category;
import com.example.blog_management.service.impl.BlogService;
import com.example.blog_management.service.impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/listBlog")
    public ResponseEntity<Iterable<Blog>> findAll() {
        List<Blog> blogs = (List<Blog>) blogService.findAll();
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> findById(@PathVariable int id) {
        Optional<Blog> blogs = blogService.findById(id);

        if (!blogs.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogs.get(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> save(@RequestBody Blog blog) {
        blogService.save(blog);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Blog> update(@PathVariable int id, @RequestBody Blog blog) {
        Optional<Blog> blogs = blogService.findById(id);
        if (!blogs.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blog.setId(blogs.get().getId());
        blogService.save(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Blog> delete(@PathVariable int id) {
        Optional<Blog> blogs = blogService.findById(id);
        if (!blogs.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blogService.remove(id);
        return new ResponseEntity<>(blogs.get(), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<List<Blog>> findAllBlogId(@PathVariable Integer id) {
        Optional<Category> categories = categoryService.findById(id);
        List<Blog> blogs = blogService.findAllById(id);
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

}
