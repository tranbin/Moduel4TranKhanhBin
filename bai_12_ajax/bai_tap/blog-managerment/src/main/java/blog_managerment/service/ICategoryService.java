package blog_managerment.service;

import blog_managerment.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    Category save(Category category);

    void delete(int id);

    Category findById(int id);
}
