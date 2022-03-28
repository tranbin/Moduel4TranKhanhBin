package blog_managerment.service;

import blog_managerment.dto.BlogDTO;
import blog_managerment.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    Blog save(Blog blog);

    void delete(int id);

    Blog findById(int id);

    void saveBlogDTO(BlogDTO blogDTO);

    List<Blog> findByName(String name);

    List<Blog> selectLimit(Integer id);
}
