package app.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IService<T> {
    void create(T t);
    void update(T t);
    T findById(long id);
    List<T> findAll();

    Page<T> findAll(Pageable pageable);

    void deleteById(long id);
}
