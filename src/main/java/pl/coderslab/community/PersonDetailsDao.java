package pl.coderslab.community;

import org.springframework.stereotype.Repository;
import pl.coderslab.library.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PersonDetailsDao {
    @PersistenceContext
    EntityManager entityManager;

    public void save(PersonDetails personDetails) {
        entityManager.persist(personDetails);
    }

    public void update(PersonDetails personDetails) {
        entityManager.merge(personDetails);
    }

    public PersonDetails findByID(Long id) {
        return entityManager.find(PersonDetails.class, id);
    }

    public void delete(Long id){
        PersonDetails byID = this.findByID(id);
        entityManager.remove(entityManager.contains(byID) ? byID : entityManager.merge(byID));
    }
}
