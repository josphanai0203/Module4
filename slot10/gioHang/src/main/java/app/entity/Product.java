package app.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private String name;
    private String image;
    @Column(columnDefinition = "LONGBLOB")
    private String description;
    private long price;
    private short discount;

}
