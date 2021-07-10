package pl.coderslab.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.library.Book;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Controller
@RequestMapping("/validate")
public class ValidationController {
    private final Validator validator;
    private static final Logger logger = LoggerFactory.getLogger(ValidationController.class);


    public ValidationController(Validator validator) {
        this.validator = validator;
    }

    @RequestMapping("")
    public String validate(Model model) {
        Book book = new Book();

        Set<ConstraintViolation<Book>> violations = validator.validate(book);
//        if (!violations.isEmpty()){
//            for (ConstraintViolation<Book> violation : violations) {
//                logger.info("{} - {}",violation.getPropertyPath(), violation.getMessage());
//            }
//        }
        model.addAttribute("violations",violations);
        return "validations/validate";
    }
}
