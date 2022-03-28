package blog_managerment.service.impl;

import blog_managerment.dto.BlogDTO;
import blog_managerment.model.Blog;
import blog_managerment.model.Category;
import blog_managerment.repository.BlogRepository;
import blog_managerment.repository.CategoryRepository;
import blog_managerment.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog save(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public void delete(int id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void saveBlogDTO(BlogDTO blogDTO) {
        Blog blog = new Blog();
        blog.setNameBlog(blogDTO.getNameBlog());
        blog.setContent(blogDTO.getContent());
        blog.setDate(blogDTO.getDate());
        Category category = categoryRepository.findById(Integer.valueOf(blogDTO.getCategory())).orElse(null);
        blog.setCategory(category);
        blogRepository.save(blog);
    }

    @Override
    public List<Blog> findByName(String name) {
        return blogRepository.findByInput(name);
    }

    @Override
    public List<Blog> selectLimit(Integer id) {
        return blogRepository.selectLimit(id);
    }
}
