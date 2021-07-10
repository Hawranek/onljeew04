package pl.coderslab.library;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.repository.AuthorRepository;
import pl.coderslab.repository.BookRepository;
import pl.coderslab.repository.CategoryRepository;
import pl.coderslab.repository.PublisherRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/book-form")
@Slf4j
public class BookFormController {

    //    private final BookDao bookDao;
//    private final PublisherDao publisherDao;
//    private final AuthorDao authorDao;
    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    public BookFormController(PublisherDao publisherDao, AuthorDao authorDao, BookRepository bookRepository, CategoryRepository categoryRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
//        this.bookDao = bookDao;
//        this.publisherDao = publisherDao;
//        this.authorDao = authorDao;
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @ModelAttribute("authors")
    public List<Author> authors() {
        return authorRepository.findAll();
    }

    @ModelAttribute("publishers")
    public List<Publisher> publishers() {
        return publisherRepository.findAll();
    }

    @RequestMapping("/all")
    public String list(Model model) {
//        model.addAttribute("books", bookDao.findAll());
        model.addAttribute("books", bookRepository.findAll());
        return "books/all";
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("book", new Book());
        return "books/form";
    }

    @GetMapping("/form/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Optional<Book> book = bookRepository.findById(id);
        model.addAttribute("book", book.orElse(null));
        return "books/form";
    }

    @PostMapping("/form")
    public String form(@Valid Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "books/form";
        }
        bookRepository.save(book);
        return "redirect:/book-form/all";
    }

//    @GetMapping("/edit")
//    public String edit(@RequestParam Long id, Model model) {
//        Optional<Book> byId = bookRepository.findById(id);
//        model.addAttribute("book", byId.orElse(null));
//        return "books/edit";
//    }
//
//    @PostMapping("/edit")
//    public String saveEdit(Book book) {
//        bookRepository.save(book);
//        return "redirect:/book-form/all";
//    }

    @GetMapping("/del/{id}")
    public String delete(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookRepository.findById(id));
        return "books/delete";
    }

    @GetMapping("/delete/{id}")
    public String deleteJsp(@PathVariable Long id) {
        bookRepository.deleteById(id);
        return "redirect:/book-form/all";
    }

    @GetMapping("/repotest")
    public String repoTest() {
        List<Book> byTitle = bookRepository.findByTitle("dupajasiu");
        log.info("By title: {}", byTitle);

        Category category = categoryRepository.findById(1L).orElse(null);
        List<Book> byCategory = bookRepository.findByCategory(category);
        log.info("By Category: {}", byCategory);

        List<Book> byCategoryId = bookRepository.findByCategoryId(1L);
        log.info("By CategoryId: {}", byCategoryId);

        Author author = authorRepository.findById(1L).orElse(null);
        List<Book> byAuthor = bookRepository.findByAuthors(author);
        log.info("By Author: {}", byAuthor);

        Publisher publisher = publisherRepository.findById(1L).orElse(null);
        List<Book> byPublisher = bookRepository.findByPublisher(publisher);
        log.info("By Publisher: {}", byPublisher);

        int rating = 10;
        List<Book> byRating = bookRepository.findByRating(rating);
        log.info("By Rating: {}",byRating);

        Book firstByCategoryOrderByTitle = bookRepository.findFirstByCategoryOrderByTitle(category);
        log.info("First of Category order by title: {}",firstByCategoryOrderByTitle);

        return "";
    }
}
