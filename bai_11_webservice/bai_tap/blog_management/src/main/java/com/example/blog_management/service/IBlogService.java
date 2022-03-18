package com.example.blog_management.service;

import com.example.blog_management.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogService extends IGeneralService<Blog> {
    List<Blog> findAllById(int id);
}
