package app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Book {
    @Id
    @GeneratedValue
    @NotNull
    private long bookId;
    @NotNull
    private String bookName;
    @NotNull
    private String author;
    @Min(0)
    private int quantity;
    @OneToMany(mappedBy = "book")
    private List<OrderBook> bookList;
}
