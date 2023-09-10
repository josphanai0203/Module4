package app.repository;

import app.model.OrderBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderBookRepository extends JpaRepository<OrderBook,Long> {
}
