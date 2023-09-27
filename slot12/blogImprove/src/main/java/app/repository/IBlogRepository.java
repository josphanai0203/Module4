package app.repository;

import app.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    Page<Blog> findByBlogCategory(Integer categoryId, Pageable pageable);

    Page<Blog> findByBlogCategoryBlogCategoryId(Integer id, Pageable pageable);
    List<Blog> findByBlogCategoryBlogCategoryId(Integer id);

    List<Blog> findByTitleContainsIgnoreCase(String title);
}
