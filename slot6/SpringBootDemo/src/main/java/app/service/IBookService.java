package app.service;

import app.entity.Book;
import app.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IBookService {
    void create(Book book);
    void update(Book book);
    Book findById(long id);
    List<Book> findAll();

    Page<Book> findAll(Pageable pageable);

    Slice<Book> findAllSlice(Pageable pageable);
    void deleteById(long id);
}
