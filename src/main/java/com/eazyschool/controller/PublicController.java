package com.eazyschool.controller;

import com.eazyschool.model.Person;
import com.eazyschool.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("public")
public class PublicController {

    @Autowired
    PersonService personService;

    @GetMapping("/register")
    public String displayRegisterPage(Model model){
        model.addAttribute("person", new Person());
        return "register";
    }

    @PostMapping("/createUser")
    public String createUser(@Valid @ModelAttribute("person") Person person, Errors errors){
        if (errors.hasErrors()) return "register";
        personService.createNewPerson(person);
        return "redirect:/login?register=true";
    }
}
