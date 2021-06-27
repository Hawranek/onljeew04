package pl.coderslab.library;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AuthorDao {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Author author) {
        entityManager.persist(author);
    }

    public void update(Author author) {
        entityManager.merge(author);
    }

    public Author findByID(Long id) {
        return entityManager.find(Author.class, id);
    }

    public void delete(Long id){
        Author byID = this.findByID(id);
        entityManager.remove(entityManager.contains(byID) ? byID : entityManager.merge(byID));
    }

    public List<Author> findAll(){
        return entityManager
                .createQuery("select a from Author a")
                .getResultList();
    }
}
