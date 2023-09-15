package app.service;

import app.entity.Blog;
import app.entity.BlogCategory;
import app.repository.IBlogCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryBlogService implements IService<BlogCategory>{
    @Autowired
    private IBlogCategoryRepository categoryRepository;
    @Override
    public void create(BlogCategory blogCategory) {
        categoryRepository.save(blogCategory);
    }

    @Override
    public void update(BlogCategory blogCategory) {
        categoryRepository.save(blogCategory);
    }

    @Override
    public BlogCategory findById(Integer id) {
        return null;
    }

    @Override
    public List<BlogCategory> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Page<BlogCategory> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {
        categoryRepository.deleteById(id);
    }
    public List<Blog> findByCategory(Integer id){
        return categoryRepository.findById(id).get().getBlogList();
    };
}
