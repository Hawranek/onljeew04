package pl.coderslab.library;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "authors")
@Getter
@Setter
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;

    @Override
    public String toString() {
        return "Author[" +
                "id=" + id +
                ", firstName=" + firstName +
                ", lastName=" + lastName +
                ']';
    }
}
