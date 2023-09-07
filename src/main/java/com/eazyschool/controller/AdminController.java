package com.eazyschool.controller;

import com.eazyschool.model.EazyClass;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping("/displayClasses")
    public String displayClasses(Model model){
        model.addAttribute("eazyClass", new EazyClass());
        return "classes";
    }
}
