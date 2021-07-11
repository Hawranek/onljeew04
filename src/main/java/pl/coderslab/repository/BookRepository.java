package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.library.Author;
import pl.coderslab.library.Book;
import pl.coderslab.library.Category;
import pl.coderslab.library.Publisher;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByTitle(String title);

    List<Book> findByCategory(Category category);

    List<Book> findByCategoryId(Long id);

    List<Book> findByAuthors(Author author);

    List<Book> findByPublisher(Publisher publisher);

    List<Book> findByRating(int rating);

    Book findFirstByCategoryOrderByTitle(Category category);

    @Query("select b from Book b where b.category = :cat")
    List<Book> findBooksByCategory(@Param("cat") Category category);

    @Query("select b from Book b where b.title = ?1")
    List<Book> findBooksByTitle(String title);

    @Query("select b from Book b where b.rating between ?1 and ?2")
    List<Book> findBooksByRatingBetween(int min, int max);

    @Query("select b from Book b where b.publisher = ?1")
    List<Book> findBooksByPublisher(Publisher publisher);

    @Query(value = "select * from books where category_id = :cat order by title limit 1",
            nativeQuery = true)
    List<Book> findFirstBookByCategoryOrOrderByTitle(@Param("cat") Category category);
}
