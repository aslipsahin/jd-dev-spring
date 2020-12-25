package com.cyber.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

/*
    @RequestMapping annotation maps HTTP requests to handler methods of MVC and REST controllers.
    It can be applied to class-level and/or method-level in a container.
        You can see examples in method level examples in this class and in class level examples in StudentController
        and MentorController classes. If you use it in class level, it will be added to the url for all methods.
    If there are multiple URLs which can be mapped to single method then an array of string parameters can be passed.
 */

/*
    @RequestMapping(method=RequestMethod.GET, value=”/asli/”) is the same with
    @GetMapping(“/asli”)
 */

/*
    @RequestMapping can be used in method level or/a
 */
    @RequestMapping
    public String getRequestMapping(){
//        the template (view) that i want to return is "home", so i have to create this template (home.html) as well
        return "home";
    }

    @RequestMapping("/asli")
    public String getRequestMapping2(){
        return "home";
    }

    @RequestMapping(method= RequestMethod.GET, value="/asli")
    public String getRequestMapping3(){
        return "home";
    }

    @GetMapping("/cyber")
    public String getRequestMapping4(){
        return "home";
    }

    @PostMapping("/spring")
    public String getRequestMapping5(){
        return "home";
    }

//    Path variable with 1 variable
    @GetMapping("/home/{name}")
    public String pathVariableEx(@PathVariable("name") String name){
        System.out.println("name is : " + name);
        return "home";
//        http://localhost:8080/home/asli
    }

//    Path variable with 2 variables
    @GetMapping("/home/{name}/{email}")
    public String pathVariableEx2(@PathVariable("name") String name, @PathVariable("email") String email){
        System.out.println("name is : " + name);
        System.out.println("email is : " + email);
        return "home";
//        http://localhost:8080/home/asli/a@gmail.com
    }

//    Query Parameter
    @GetMapping("home/course4")
    public String requestParamEx(@RequestParam("course") String course){
        System.out.println("name is : " + course);
        return "home";
//        http://localhost:8080/hom/course4?course=asli
    }

//    Query Parameter (Optional with default value)
    @GetMapping("/course3")
    public String requestParamEx2(@RequestParam(value = "course2", required = false, defaultValue = "Cyber") String name){
        System.out.println("name is : " + name);
        return "home";
//        http://localhost:8080/course3?course2=asli
    }
}