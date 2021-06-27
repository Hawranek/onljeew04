package pl.coderslab.community;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

//    @RequestMapping("/add")
//    @ResponseBody
//    public String add(){
//        Person person = new Person();
//        person.setEmail("jakisemail@fajny.pl");
//        person.setLogin("uzytkownik");
//        person.setPassword("haslo");
//
//        PersonDetails personDetails = new PersonDetails();
//        personDetails.setFirstName("Czesiek");
//        personDetails.setLastName("Kurzajka");
//        personDetails.setStreet("Jakastam");
//        personDetails.setStreetNumber(10);
//        personDetails.setCity("Czesionkowo");
//        personDetailsDao.save(personDetails);
//
//        person.setPersonDetails(personDetails);
//        personDao.save(person);
//
//        return "zapisano osobę: "+person;
//    }

    @GetMapping("/add")
    public String addPerson(Model model){
        model.addAttribute("person", new Person());
        return "person/add";
    }
//    Zadanie 1
//    @PostMapping("/add")
//    public String savePerson(
//            @RequestParam String login,
//            @RequestParam String password,
//            @RequestParam String email
//    ){
//        Person person = new Person();
//        person.setLogin(login);
//        person.setPassword(password);
//        person.setEmail(email);
//        personDao.save(person);
//        return "redirect:/person/add";
//    }

    // Zadanie 2
    @PostMapping("/add")
    public String savePerson(
            Person person
    ){
        personDao.save(person);
        return "redirect:/person/add";
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
