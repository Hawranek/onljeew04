package pl.coderslab.library;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;

    public BookController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
    }

    @RequestMapping("/add")
    @ResponseBody
    public String addBook() {
        Publisher publisher = new Publisher();
        publisher.setName("Helion");
        publisherDao.save(publisher);

        //opcja 1 dodawania
//        Author author1 = authorDao.findByID(2l);
//        Author author2 = authorDao.findByID(7l);

        //opcja 2 dodawania
        List<Author> authorList = Arrays.asList(
                authorDao.findByID(2l),
                authorDao.findByID(7l)
        );

        Book newBook = new Book();
        newBook.setTitle("Dżuma");
        newBook.setDescription("Książka o dżumie");
        newBook.setRating(10);

        newBook.setPublisher(publisher);
        //opcja 1
//        newBook.getAuthors().add(author1);
//        newBook.getAuthors().add(author2);
        //opcja 2
        newBook.setAuthors(authorList);

        bookDao.save(newBook);
        return "dodano książkę" + newBook.toString();
    }

    @RequestMapping("/update/{id}")
    @ResponseBody
    public String updateBook(@PathVariable long id) {
        Book byID = bookDao.findByID(id);
        byID.setTitle("Nie Dżuma");
        byID.setRating(7);
        bookDao.update(byID);
        return "Zaktualizowana książka: " + byID.toString();
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public String getBook(@PathVariable Long id) {
        return "Pobrana książka:\n" + bookDao.findByID(id);
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable Long id) {
        String info = bookDao.findByID(id).toString();
        bookDao.delete(id);
        return "Usunięta książka: " + info;
    }
}
