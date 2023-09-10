package app.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderBook {
    @Id
    private long id;
    @ManyToOne
    @JoinColumn(name = "bookId")
    private Book book;
}
