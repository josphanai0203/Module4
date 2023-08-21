package app.service;

import app.entity.Blog;
import app.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogServiceImp implements BlogService{
    @Autowired
    private BlogRepository blogRepository;
    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public void create(Blog blog) {
        blogRepository.saveAndFlush(blog);
    }

    @Override
    public void update(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void delete(long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Blog findById(long id) {
        return blogRepository.findById(id).orElse(null);
    }
}
