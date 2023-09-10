package app.service;

import app.model.Book;
import app.model.OrderBook;
import app.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IService<Book> {
    @Autowired
    private IBookRepository bookRepository;
    @Autowired
    private OrderBookService orderBookService;

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
        return bookRepository.findById(id).orElse(null) ;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public void deleteById(long id) {
        bookRepository.deleteById(id);
    }
    public long rentBook(Long id){
        Book b = bookRepository.findById(id).orElse(null);
        b.setQuantity(b.getQuantity() - 1);
        bookRepository.save(b);
        OrderBook orderBook = new OrderBook();
        orderBook.setBook(b);
       return orderBookService.create(orderBook);
    }
    public boolean returnBook(Long id){
        OrderBook b = orderBookService.findById(id);
        if(b!=null){
            b.getBook().setQuantity(b.getBook().getQuantity()+1);
            bookRepository.save(b.getBook());
            orderBookService.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
