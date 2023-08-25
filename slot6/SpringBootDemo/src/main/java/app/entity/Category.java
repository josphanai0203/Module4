package app.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class Category {
    @Id
    @GeneratedValue
    private int categoryId;
    private String categoryName;
    @OneToMany(mappedBy = "category")
    private List<Book> bookList;

}
