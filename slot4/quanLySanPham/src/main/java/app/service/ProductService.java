package app.service;

import app.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService implements IProductService{
    private static final Map<Integer, Product> products;

    static {

        products = new HashMap<>();
        products.put(1, new Product(1, "John", 10, 100000));
        products.put(2, new Product(2, "Bill", 20, 200000));
        products.put(3, new Product(3, "Alex", 30, 150000));
        products.put(4, new Product(4, "Adam", 40, 250000));
        products.put(5, new Product(5, "Sophia", 40, 300000));
        products.put(6, new Product(6, "Rose", 50, 1500000));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
