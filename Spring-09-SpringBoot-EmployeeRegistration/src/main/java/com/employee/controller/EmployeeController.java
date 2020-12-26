package com.employee.controller;

import com.employee.dataGenerator.DataGenerator;
import com.employee.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.Arrays;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping("/registration")
    public String employeeCreate(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("statesList", DataGenerator.getStateList());
        return "employee/employee-create";
    }

    @PostMapping("/list")
    public String employeeList(@ModelAttribute("employee") Employee employee, Model model) {
        model.addAttribute("employeeList", Arrays.asList(employee));
        int birthYear = LocalDate.parse(employee.getBirthday()).getYear();
        model.addAttribute("age", LocalDate.now().getYear() - birthYear);
        return "employee/employee-list";
    }
}