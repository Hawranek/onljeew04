package pl.coderslab.library;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookDao bookDao;

    public BookController(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @RequestMapping("/add")
    @ResponseBody
    public String addBook() {
        Book newBook = new Book();
        newBook.setTitle("Dżuma");
        newBook.setDescription("Książka o dżumie");
        newBook.setRating(10);
        bookDao.save(newBook);
        return "dodano książkę" + newBook.toString();
    }

    @RequestMapping("/update/{id}")
    @ResponseBody
    public String updateBook(@PathVariable long id){
        Book byID = bookDao.findByID(id);
        byID.setTitle("Nie Dżuma");
        byID.setRating(7);
        bookDao.update(byID);
        return "Zaktualizowana książka: "+byID.toString();
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public String getBook(@PathVariable Long id){
        return "Pobrana książka:\n"+bookDao.findByID(id);
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable Long id){
        String info=bookDao.findByID(id).toString();
        bookDao.delete(id);
        return "Usunięta książka: "+info;
    }
}
