package app.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    @Column(length = 10000)
    private String content;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date publishDate;

}
