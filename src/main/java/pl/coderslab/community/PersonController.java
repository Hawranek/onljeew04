package pl.coderslab.community;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.library.Book;

@Controller
@RequestMapping("/person")
public class PersonController {

    private PersonDao personDao;
    private PersonDetailsDao personDetailsDao;

    public PersonController(PersonDao personDao, PersonDetailsDao personDetailsDao) {
        this.personDao = personDao;
        this.personDetailsDao = personDetailsDao;
    }

    @RequestMapping("/add")
    @ResponseBody
    public String add(){
        Person person = new Person();
        person.setEmail("jakisemail@fajny.pl");
        person.setLogin("uzytkownik");
        person.setPassword("haslo");

        PersonDetails personDetails = new PersonDetails();
        personDetails.setFirstName("Czesiek");
        personDetails.setLastName("Kurzajka");
        personDetails.setStreet("Jakastam");
        personDetails.setStreetNumber(10);
        personDetails.setCity("Czesionkowo");
        personDetailsDao.save(personDetails);

        person.setPersonDetails(personDetails);
        personDao.save(person);

        return "zapisano osobę: "+person;
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public String get(@PathVariable long id){
        return "Szukany użytkownik: "+personDao.findByID(id);
    }

    @RequestMapping("/update/{id}")
    @ResponseBody
    public String update(@PathVariable long id){
        Person byID = personDao.findByID(id);
        byID.getPersonDetails().setLastName("Cieszkowski");
        byID.getPersonDetails().setCity("Warszawa");
        personDao.update(byID);
        return "Zaktualizowany uzytkownik: " + byID;
    }

    @RequestMapping("/del/{id}")
    @ResponseBody
    public String delete(@PathVariable long id){
        String info = personDao.findByID(id).toString();
        personDao.delete(id);
        return "Usunięta książka: " + info;
    }
}
