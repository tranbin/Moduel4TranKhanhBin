package blog_managerment.service;

import blog_managerment.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    void saveBlog(Blog blog);
    void deleteBlog(int id);
    Blog findBlogById(int id);

    Page<Blog> findAll(Pageable pageable);
    List<Blog> findAllBlogById(int id);
    Page<Blog> findAllBlogById(int id,Pageable pageable);

    Page<Blog> findByContent(String content,Pageable pageable);
}
