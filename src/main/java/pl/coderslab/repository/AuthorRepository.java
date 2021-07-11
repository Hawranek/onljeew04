package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.library.Author;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author findByEmail(String email);
    Author findByPesel(String pesel);
    List<Author> findByLastName(String lastName);

    @Query("select a from Author a where a.email like :start%")
    List<Author> findAuthorsByEmailStartsWith(@Param("start") String start);

    @Query("select a from Author a where a.pesel like :start%")
    List<Author> findAuthorsByPeselStartingWith(@Param("start") String start);
}
