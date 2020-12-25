package com.cybermvc.controller;

import com.cybermvc.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/student")
public class StudentController {

    /*
    Bind the data "String name" to Model --> carry name to view
    Add <html xmlns:th="http://www.thymeleaf.org"> to the html file
    you can use 'th' attribute now like <h2 th:text="${name}"></h2>
    */
    @GetMapping("/welcome")
    public String homePage(Model model) {
        model.addAttribute("name", "Asli");
        model.addAttribute("course", "MVC");

        String subject = "Collections";
        model.addAttribute("subject", subject);

//      create some random studentId (0-1000) and show it in the UI
        int studentId = new Random().nextInt(1000);
        model.addAttribute("id", studentId);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(4);
        numbers.add(5);
        numbers.add(7);
        model.addAttribute("numbers", numbers);

//      print a birthday
        LocalDate birthday = LocalDate.now().minusYears(39);
        model.addAttribute("birthday", birthday);

//      create an object from Student class
        Student student = new Student(1, "Bob", "Smith");
        model.addAttribute("student", student);

        return "student/welcome";
    }

    @GetMapping("/register")
    public String homePage2() {
        return "student/register";
    }
}
