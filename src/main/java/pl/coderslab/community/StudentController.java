package pl.coderslab.community;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @ModelAttribute("hobbies")
    public List<String> hobbies() {
        return Arrays.asList(
                "pływanie",
                "skakanie",
                "piłka nożna",
                "koszykówka",
                "siatkówka"
        );
    }

    @ModelAttribute("gender")
    public List<String> gender() {
        return Arrays.asList("male", "female");
    }

    @ModelAttribute("countries")
    public List<String> countries() {
        return Arrays.asList("Poland", "Germany", "France", "Russia", "Denmark");
    }

    @ModelAttribute("skills")
    public List<String> programmingSkills() {
        return Arrays.asList(
                "java",
                "php",
                "Python",
                "C++",
                "C#"
        );
    }

    @GetMapping("/add")
    public String addStudent(Model model) {
        model.addAttribute("student", new Student());
        return "student/add";
    }

    @PostMapping("/add")
    public String showStudent(Student student, Model model) {
        model.addAttribute("student", student);
        return "/student/show";
    }

}
