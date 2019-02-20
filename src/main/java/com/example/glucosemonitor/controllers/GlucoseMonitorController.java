package com.example.glucosemonitor.controllers;

import com.example.glucosemonitor.models.GlucoseMonitor;
import com.example.glucosemonitor.models.GlucoseMonitorData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@RequestMapping("gm")
public class GlucoseMonitorController {

    @RequestMapping(value = "") //Views Part 1
    public String index(Model model) {

        model.addAttribute("gmdata", GlucoseMonitorData.getAll());
        model.addAttribute("title", "Glucose Monitor");
        return "gm/index"; //Returns index.html
    }

    /*@RequestMapping(value = "add", method = RequestMethod.GET)
    public String showAddForm(Model model) {
        model.addAttribute("title", "Add Data");
        model.addAttribute("gm", new GlucoseMonitor());
        *//*adding the "gm" attribute fixes the Neither BindingResult nor plain target object
        for bean name available as request attribute error*//*
        return "gm/add";
    }*/
    @GetMapping("add")
    public String showAddForm(Model model) {
        model.addAttribute("gm", new GlucoseMonitor());
        return "gm/add";
    }

    //@RequestMapping(value = "add", method = RequestMethod.POST)
    @PostMapping("add")
    public String processAddForm(@Valid @ModelAttribute("gm") GlucoseMonitor glucoseInfo, Errors errors, Model model) {

        if (errors.hasErrors()) {
            //model.addAttribute("title", "Add Data");
            //model.addAttribute("gm",new GlucoseMonitor());
            //fixes binding issue when sending empty request, but doesn't display error annotations
            //UPDATE: adding parameter to @ModelAttribute fixed annotation issue not displaying
            return "gm/add";
        }

        GlucoseMonitorData.add(glucoseInfo);

        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveGlucoseMonitorForm(Model model) {
        model.addAttribute("gmdata", GlucoseMonitorData.getAll());
        model.addAttribute("title", "Remove Data");
        return "gm/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveCheeseForm(@RequestParam int[] gmIds) {

        for (int gmId : gmIds) {

            GlucoseMonitorData.remove(gmId);
        }

        return "redirect:";
    }
}
//although you can specify action to redirect POST submissions to different URL,
//you can leave empty, and just have a method for both GET and POST (common practice)