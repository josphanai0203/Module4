package app.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue
    private long bookId;

    private String name;
    private String author;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date publish;

    private long price;

    @ManyToOne
    @JoinColumn(name = "categoryID")
    private Category category;

}
