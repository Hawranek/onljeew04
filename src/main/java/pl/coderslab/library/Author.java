package pl.coderslab.library;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.pl.PESEL;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "authors")
@Getter
@Setter
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;

    @PESEL
    private Integer pesel;
    @Email
    private String email;

    @Override
    public String toString() {
        return "Author[" +
                "id=" + id +
                ", firstName=" + firstName +
                ", lastName=" + lastName +
                ']';
    }
}
