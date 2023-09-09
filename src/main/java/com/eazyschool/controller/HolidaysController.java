package com.eazyschool.controller;

import com.eazyschool.model.Holiday;
import com.eazyschool.repository.HolidaysRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Controller
public class HolidaysController {

    @Autowired
    HolidaysRepository holidaysRepository;

    @GetMapping("/holidays/{display}")
    public String displayHolidays(@PathVariable String display, Model model) {

        if(display!=null && display.equals("all")){
            model.addAttribute("festival", true);
            model.addAttribute("federal", true);
        }
        else if(display!=null && display.equals("festival")){
            model.addAttribute("festival", true);
        }
        else if(display!=null && display.equals("federal")){
            model.addAttribute("federal", true);
        }

        Iterable<Holiday> ItrHolidays = holidaysRepository.findAll();
        List<Holiday> holidays = StreamSupport.stream(ItrHolidays.spliterator(), false).toList();

        Holiday.Type[] types = Holiday.Type.values();
        for (Holiday.Type type : types) {
            model.addAttribute(type.toString(),
                    (holidays.stream().filter(holiday -> holiday.getType().equals(type)).collect(Collectors.toList())));
        }
        return "holidays";
    }
}
