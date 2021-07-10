package pl.coderslab.library;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/pub")
public class PublisherController {
    private PublisherDao publisherDao;

    public PublisherController(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }



    @GetMapping("/form")
    public String addPublisher(Model model) {
        model.addAttribute("publisher", new Publisher());
        return "publishers/form";
    }

    @GetMapping("/form/{id}")
    public String addPublisher(@PathVariable("id") Long id, Model model) {
        model.addAttribute("publisher", publisherDao.findByID(id));
        return "publishers/form";
    }

    @PostMapping("/form")
    public String addPublisher(@Valid Publisher publisher, BindingResult result) {
        if (result.hasErrors()) {
            return "publishers/form";
        }
        if(publisher.getId()!=null) {
            publisherDao.update(publisher);
        }else {
            publisherDao.save(publisher);
        }
        return "redirect:/pub/all";
    }

//    @RequestMapping("/update/{id}")
//    @ResponseBody
//    public String updatePublisher(@PathVariable long id) {
//        Publisher byID = publisherDao.findByID(id);
//        byID.setName("Twoja Książka");
//        publisherDao.update(byID);
//        return "Zaktualizowany wydawca:\n" + byID;
//    }

    @GetMapping("/all")
    public String all(Model model){
        model.addAttribute("publishers", publisherDao.findAll());
        return "publishers/all";
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public String getAuthor(@PathVariable Long id) {
        return "Pobrany wydawca:\n" + publisherDao.findByID(id);
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String deleteAuthor(@PathVariable Long id) {
        String info = publisherDao.findByID(id).toString();
        publisherDao.delete(id);
        return "Usunięty wydawca: " + info;
    }
}
