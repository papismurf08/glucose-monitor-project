package com.example.glucosemonitor.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/createrecord")
public class ChartController {

    @GetMapping//(value="")
    public String index() {
        return "createrecord/index";
    }

}
