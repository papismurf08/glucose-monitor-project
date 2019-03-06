package com.example.glucosemonitor.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("chart")
//@SessionAttributes("category")
public class ChartController {

    @GetMapping(value = "")
    public String index() {

        /*model.addAttribute("stats", createRecordRepo.findAll());
        model.addAttribute("title", "Glucose Monitor");*/

        return "chart/index";
    }
}
