package com.eazyschool.controller;

import com.eazyschool.model.Address;
import com.eazyschool.model.Person;
import com.eazyschool.model.Profile;
import com.eazyschool.repository.PersonRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfileController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/displayProfile")
    public ModelAndView displayProfile(HttpSession session){
        Person person = (Person) session.getAttribute("loggedInPerson");
        Profile profile = new Profile();
        profile.setName(person.getName());
        profile.setMobileNumber(person.getMobileNumber());
        profile.setEmail(person.getEmail());
        if(person.getAddress() != null){
            profile.setAddress1(person.getAddress().getAddress1());
            profile.setAddress2(person.getAddress().getAddress2());
            profile.setAddress2(person.getAddress().getCity());
            profile.setAddress2(person.getAddress().getState());
            profile.setAddress2(person.getAddress().getZipCode());
        }
        return new ModelAndView("profile.html").addObject("profile", profile);
    }

    @PostMapping("/updateProfile")
    public String updateProfile(@Valid @ModelAttribute("profile")Profile profile, Errors errors, HttpSession session){
        if(errors.hasErrors()){
            return "profile";
        }
        else{
            Person person = (Person) session.getAttribute("loggedInPerson");
            person.setName(profile.getName());
            person.setMobileNumber(profile.getMobileNumber());
            person.setEmail(profile.getEmail());
            if(person.getAddress() == null){
                person.setAddress(new Address());
            }
            person.getAddress().setAddress1(profile.getAddress1());
            person.getAddress().setAddress2(profile.getAddress2());
            person.getAddress().setCity(profile.getCity());
            person.getAddress().setState(profile.getState());
            person.getAddress().setZipCode(profile.getZipCode());
            personRepository.save(person);
            session.setAttribute("loggedInPerson", person);
            return "redirect:/displayProfile";
        }
    }
}
