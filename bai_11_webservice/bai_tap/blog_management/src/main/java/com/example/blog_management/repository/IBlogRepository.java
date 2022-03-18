package com.example.blog_management.repository;

import com.example.blog_management.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    @Query(value = " select * from blog where blog.category_id = ?1",  nativeQuery = true)
    List<Blog> findAllBlogById(int id);

}
