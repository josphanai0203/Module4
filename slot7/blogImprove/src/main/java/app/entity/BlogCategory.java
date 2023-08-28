package app.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BlogCategory {
    @Id
    private Integer blogCategoryId;
    private String categoryName;
    @OneToMany(mappedBy = "blogCategory")
    private List<Blog> blogList;
}
