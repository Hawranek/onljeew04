package pl.coderslab.community;

import org.springframework.stereotype.Repository;
import pl.coderslab.library.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PersonDao {
    @PersistenceContext
    EntityManager entityManager;

    public void save(Person person) {
        entityManager.persist(person);
    }

    public void update(Person person) {
        entityManager.merge(person);
    }

    public Person findByID(Long id) {
        return entityManager.find(Person.class, id);
    }

    public void delete(Long id){
        Person byID = this.findByID(id);
        entityManager.remove(entityManager.contains(byID) ? byID : entityManager.merge(byID));
    }
}
