package pl.coderslab.library;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class BookDao {
    @PersistenceContext
    EntityManager entityManager;

    public void save(Book book) {
        entityManager.persist(book);
    }

    public void update(Book book) {
        entityManager.merge(book);
    }

    public Book findByID(Long id) {
        return entityManager.find(Book.class, id);
    }

    public void delete(Long id){
        Book byID = this.findByID(id);
        entityManager.remove(entityManager.contains(byID) ? byID : entityManager.merge(byID));
    }

    public List<Book> findAll(){
        return entityManager.createQuery("select b from Book b").getResultList();
    }

    public List<Book> findAllByRating(int rating){
        return entityManager
                .createQuery("select b from Book b where b.rating=:rate")
                .setParameter("rate",rating)
                .getResultList();
    }

    public List<Book> findAllWithPublisher(){
        return entityManager
                .createQuery("select b from Book b where b.publisher.id is not null ")
                .getResultList();
    }

    public List<Book> findAllWithExactPublisher(Publisher publisher){
        return entityManager
                .createQuery("select b from Book b where b.publisher = :pub ")
                .setParameter("pub",publisher)
                .getResultList();
    }

    public List<Book> findAllByAuthor(Author author){
        return entityManager
                .createQuery("select b from Book b where :paramAuthor member of b.authors")
                .setParameter("paramAuthor",author)
                .getResultList();
    }

}
