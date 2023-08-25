package app.service;

import java.util.List;

public interface IUserService<T> {
    void add(T t);
    List<T> findAll();

}
