package app.repository;

import app.entity.Blog;
import app.entity.BlogCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IBlogCategoryRepository extends JpaRepository<BlogCategory,Integer> {
}
