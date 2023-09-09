package com.eazyschool.controller;

import com.eazyschool.model.Contact;
import com.eazyschool.service.ContactService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ContactController {

    private static Logger logger = LoggerFactory.getLogger(ContactController.class);

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService){
        this.contactService = contactService;
    }

    @RequestMapping("/contact")
    public String displayContactPage(Model model){
        model.addAttribute("contact", new Contact());
        return "contact";
    }

    @PostMapping("/saveMsg")
    public String sendMessage(@Valid @ModelAttribute("contact") Contact contact, Errors errors){
        if(errors.hasErrors()){
            return "contact";
        }
        contactService.saveMessageDetails(contact);
        return "redirect:/contact";
    }

    @GetMapping("/displayMessages/page/{pageNum}")
    public String displayMessages(Model model, @PathVariable int pageNum, @RequestParam String sortDir, @RequestParam String sortField){
        Page<Contact> messagePage = contactService.findMessagesWithOpenStatus(pageNum,sortField, sortDir);
        List<Contact> contactList = messagePage.getContent();
        model.addAttribute("contactMsgs", contactList);
        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", messagePage.getTotalPages());
        model.addAttribute("totalMsgs", messagePage.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortFir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        return "messages";
    }

    @GetMapping("/closeMsg")
    public String closeMessage(@RequestParam int id, Authentication authentication){
        contactService.updateMsgStatus(id);
        return "redirect:/displayMessages/page/1?sortField=name&sortDir=desc";
    }
}
