package app.service;

import app.entity.Book;
import app.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookService implements IBookService{
    @Autowired
    private BookRepository bookRepository;
    @Override
    public void create(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void update(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Book findById(long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public Slice<Book> findAllSlice(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public void deleteById(long id) {
        bookRepository.deleteById(id);
    }
}
