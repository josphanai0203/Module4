package app.service;

import app.model.OrderBook;
import app.repository.IBookRepository;
import app.repository.IOrderBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class OrderBookService {
    @Autowired
    private IOrderBookRepository orderBookRepository;
    @Autowired
    private IBookRepository bookRepository;

    private long randomId5Number() {
        long number;
        do {
            Random random = new Random();
            number = random.nextInt(89999) + 10000;
        } while (findById(number) != null);
        return number;

    }


    public long create(OrderBook orderBook) {
        long key = randomId5Number();
        orderBook.setId(key);
        orderBookRepository.save(orderBook);
        return key;
    }


    public void update(OrderBook orderBook) {
        orderBookRepository.save(orderBook);
    }


    public OrderBook findById(long id) {
        return orderBookRepository.findById(id).orElse(null);
    }


    public List<OrderBook> findAll() {
        return orderBookRepository.findAll();
    }


    public Page<OrderBook> findAll(Pageable pageable) {
        return null;
    }


    public void deleteById(long id) {
        orderBookRepository.deleteById(id);
    }
}
