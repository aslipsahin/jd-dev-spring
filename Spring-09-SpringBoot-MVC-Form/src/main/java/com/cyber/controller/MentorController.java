package com.cyber.controller;

import com.cyber.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/mentor")
public class MentorController {

    @GetMapping("/register")
    public String showForm(Model model) {
        model.addAttribute("mentor", new Mentor());

        List<String> batchList = Arrays.asList("B1", "B2", "B3", "B4", "B5", "B6", "B7", "B8", "B9");
        model.addAttribute("batchList", batchList);

        return "mentor/mentor-register";
    }

    /*
    This method is used to navigate to mentor/mentor-confirmation view when you submit the form in the previous method.
    (@ModelAttribute("mentor") Mentor mentorCreated) is used to capture the attribute "mentor" that is created
       previously and assign it to "mentorCreated" object. And it will be available to use in "mentor-confirmation" view.
     */
    @PostMapping("/confirm")
    public String submitForm(@ModelAttribute("mentor") Mentor mentor) {
        System.out.println(mentor.toString());
        return "mentor/mentor-confirmation";
    }

}
