package app.service;

import app.entity.Blog;
import app.entity.BlogCategory;
import app.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IService<Blog> {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public void create(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void update(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Blog findById(Integer id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }
    public Page<Blog> findAllByBlogCategoryId(Pageable pageable,Integer id){
        return blogRepository.findByBlogCategoryBlogCategoryId(id,pageable);
    }

    @Override
    public void deleteById(Integer id) {
        blogRepository.deleteById(id);
    }
    public List<Blog> findByCategoryId(Integer id){
        return blogRepository.findByBlogCategoryBlogCategoryId(id);
    }
}
