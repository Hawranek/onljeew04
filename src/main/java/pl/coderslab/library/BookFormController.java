package pl.coderslab.library;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/book-form")
public class BookFormController {

    private final BookDao bookDao;
    private final PublisherDao publisherDao;

    public BookFormController(BookDao bookDao, PublisherDao publisherDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
    }

    @RequestMapping("/all")
    public String list(Model model) {
        model.addAttribute("books", bookDao.findAll());
        return "books/all";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("publishers", publisherDao.findAll());
        model.addAttribute("book", new Book());
        return "books/add";
    }

    @PostMapping("/add")
    public String save(Book book) {
        bookDao.save(book);
        return "redirect:/book-form/all";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam Long id, Model model) {
        model.addAttribute("publishers", publisherDao.findAll());
        model.addAttribute("book", bookDao.findByID(id));
        return "books/edit";
    }

    @PostMapping("/edit")
    public String saveEdit(Book book) {
        bookDao.update(book);
        return "redirect:/book-form/all";
    }

    @GetMapping("/del/{id}")
    public String delete(@PathVariable Long id) {
        bookDao.delete(id);
        return "redirect:/book-form/all";
    }
}
