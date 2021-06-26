package pl.coderslab.library;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/authors")
public class AuthorController {
    private AuthorDao authorDao;

    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @RequestMapping("/add")
    @ResponseBody
    public String addAuthor() {
        Author newAuthor = new Author();
        newAuthor.setFirstName("Adam");
        newAuthor.setLastName("Mickiewicz");
        authorDao.save(newAuthor);
        return "dodano autora:\n" + newAuthor.toString();
    }

    @RequestMapping("/update/{id}")
    @ResponseBody
    public String updateAuthor(@PathVariable long id){
        Author byID = authorDao.findByID(id);
        byID.setFirstName("Jan");
        byID.setLastName("Kochanowski");
        authorDao.update(byID);
        return "Zaktualizowan autor:\n"+byID.toString();
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public String getAuthor(@PathVariable Long id){
        return "Pobrany autor:\n"+ authorDao.findByID(id);
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String deleteAuthor(@PathVariable Long id){
        String info= authorDao.findByID(id).toString();
        authorDao.delete(id);
        return "Usunięty autor: "+info;
    }
}
