package pl.coderslab.library;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/pub")
public class PublisherController {
    private PublisherDao publisherDao;

    public PublisherController(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }

    @RequestMapping("/add")
    @ResponseBody
    public String addPublisher() {
        Publisher newPublisher = new Publisher();
        newPublisher.setName("Cinemax");
        publisherDao.save(newPublisher);
        return "dodano wydawcę:\n" + newPublisher;
    }

    @RequestMapping("/update/{id}")
    @ResponseBody
    public String updatePublisher(@PathVariable long id){
        Publisher byID = publisherDao.findByID(id);
        byID.setName("Twoja Książka");
        publisherDao.update(byID);
        return "Zaktualizowany wydawca:\n"+byID;
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public String getAuthor(@PathVariable Long id){
        return "Pobrany wydawca:\n"+ publisherDao.findByID(id);
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String deleteAuthor(@PathVariable Long id){
        String info= publisherDao.findByID(id).toString();
        publisherDao.delete(id);
        return "Usunięty wydawca: "+info;
    }
}
