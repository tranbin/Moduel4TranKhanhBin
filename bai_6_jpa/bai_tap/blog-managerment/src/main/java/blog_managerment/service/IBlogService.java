package blog_managerment.service;

import blog_managerment.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    void saveBlog(Blog blog);
    void deleteBlog(int id);
    Blog findBlogById(int id);
}
