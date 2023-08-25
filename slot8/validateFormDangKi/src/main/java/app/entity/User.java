package app.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue
    private long id;
    @Column(length = 45)
    @Size(min = 5,max = 45,message = "First Name must greater than 5 and least than 45 character")
    private String firstName;
    @Column(length = 45)
    @Size(min = 5,max = 45 , message = "Last Name must greater than 5 and least than 45 character")
    private String lastName;
    @NotBlank
    @Pattern(regexp = "(^0||^84)[0-9]{9}",message = "The Phone Number Not Valid")
    private String phoneNumber;
    @Min(value = 18,message = "Age must greater than 18")
    private int age;
    @NotBlank
    @Email(message = "Your Email not Valid")
    private String email;
}
