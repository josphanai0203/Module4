package app.service;

import app.entity.Category;

import java.util.List;

public interface ICategoryService {
    Category findById(int id);
    List<Category> findAll();
}
