package app.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Blog {
    @Id
    @GeneratedValue
    private Integer blogId;
    private String title;
    @Column(length = 100000)
    private String content;
    private Date publishDate;
    @ManyToOne
    @JoinColumn(name = "blogCategoryId")
    private BlogCategory blogCategory;
}
