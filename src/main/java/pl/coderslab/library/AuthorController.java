package pl.coderslab.library;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/authors")
public class AuthorController {
    private AuthorDao authorDao;

    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @RequestMapping("/all")
    public String all(Model model){
        model.addAttribute("authors",authorDao.findAll());
        return "authors/all";
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("author",new Author());
        return "authors/add";
    }

    @PostMapping("/add")
    public String addAuthor(Author author) {
        authorDao.save(author);
        return "redirect:/authors/all";
    }

    @GetMapping("/edit/{id}")
    public String update(@PathVariable long id, Model model){
        model.addAttribute("author",authorDao.findByID(id));
        return "authors/edit";
    }

    @PostMapping("/edit")
    public String saveUpdate(Author author){
        authorDao.update(author);
        return "redirect:/authors/all";
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public String getAuthor(@PathVariable Long id){
        return "Pobrany autor:\n"+ authorDao.findByID(id);
    }

    @GetMapping("/del/{id}")
    public String delete(@PathVariable Long id, Model model){
        model.addAttribute("author",authorDao.findByID(id));
        return "authors/delete";
    }
    //coś nie działa

    @GetMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable Long id){
        authorDao.delete(id);
        return "redirect:/authors/all";
    }
}
