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
    @Query(value = "select * from blog where nameBlog like %?1%",nativeQuery = true)
    List<Blog> findByInput(String name);

    Page<Blog> findAll(Pageable pageable);

    @Query(value = "select * from blog LIMIT 0,?1",nativeQuery = true)
    List<Blog> selectLimit(Integer id);
}
