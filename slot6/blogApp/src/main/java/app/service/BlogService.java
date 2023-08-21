package app.service;

import app.entity.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();
    void create(Blog blog);
    void update(Blog blog);
    void delete(long id);
    Blog findById(long id);
}
