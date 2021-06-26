package pl.coderslab.library;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


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

}
