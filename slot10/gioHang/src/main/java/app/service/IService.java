package app.service;

import app.entity.Product;

import java.util.List;

public interface IService {
    List<Product> findAll();
    Product findById(Long id);
    void save(Product product);
}
