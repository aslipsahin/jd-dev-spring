package com.cybermvc.controller;

import com.cybermvc.Gender;
import com.cybermvc.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/mentor")
public class MentorController {

    @GetMapping("/list")
    public String showTable(Model model) {
        List<Mentor> mentorList = new ArrayList<>();
        mentorList.add(new Mentor("Bob", "Smith", 45, Gender.MALE));
        mentorList.add(new Mentor("John", "Bryan", 43, Gender.MALE));
        mentorList.add(new Mentor("Ammy", "Hanks", 40, Gender.FEMALE));

        model.addAttribute("mentors", mentorList);
        return "mentor/mentor-list";
    }
}
