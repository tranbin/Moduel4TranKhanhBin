package blog_managerment.repository;

import blog_managerment.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {
    @Query(value = " select * from blog where category_id = ?1", countQuery = "select count(*) from blog where category_id = ?1", nativeQuery = true)
    List<Blog> findAllBlogById(int id);

    Page<Blog> findAll(Pageable pageable);

    @Query(value = "select * from blog where content like %?%", nativeQuery = true)
    Page<Blog> findByContent(String content,Pageable pageable);
    @Query(value = " select * from blog where category_id = ?1", countQuery = "select count(*) from blog where category_id = ?1", nativeQuery = true)
    Page<Blog> findAllBlogById(int id,Pageable pageable);
}
