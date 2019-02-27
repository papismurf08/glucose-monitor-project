package com.example.glucosemonitor.controllers;

import com.example.glucosemonitor.data.GlucoseMonitorRepository;
import com.example.glucosemonitor.models.GlucoseMonitor;
import com.example.glucosemonitor.models.LogType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/gm")
@SessionAttributes("gm")

public class GlucoseMonitorController {

    @Autowired
    private GlucoseMonitorRepository gmRepo; {
        this.gmRepo = gmRepo;
    }

    @RequestMapping(value = "") //Views Part 1
    public String index(Model model) {

        //model.addAttribute("gmdata", gmRepo.findAll());
        gmRepo.findAll();
        model.addAttribute("title", "Glucose Monitor");
        return "gm/index"; //Returns index.html
    }

    @GetMapping("add")
    public String showAddForm(Model model) {
        //model.addAttribute("title", "Add Data");
        model.addAttribute("gm", new GlucoseMonitor());
        //model.addAttribute("")
        model.addAttribute("logTypes", LogType.values());
        //model.addAttribute("properties", Property.values());
        return "gm/add";
    }

    @PostMapping("add")
    public String processAddForm(@Valid @ModelAttribute("gm") GlucoseMonitor glucoseInfo, Errors errors, Model model) {

        if (errors.hasErrors()) {
            //model.addAttribute("title", "Add Data");
            //fixes binding issue when sending empty request, but doesn't display error annotations
            //UPDATE: adding parameter to @ModelAttribute fixed annotation issue not displaying
            return "gm/add";
        }

        //GlucoseMonitorData.add(glucoseInfo);
        gmRepo.save(glucoseInfo);
        return "redirect:";
    }

    /*@GetMapping("remove")
    public String displayRemoveForm(Model model) {
        //model.addAttribute("gmdata", gmRepo.findAll());
        gmRepo.findAll();
        model.addAttribute("title", "Remove Data");
        return "gm/remove";
    }

    @PostMapping("remove")
    public String processRemoveForm(@RequestParam int[] id) {

        for (int gmId : gmIds) {

            gmRepo.delete(gmId);
        }

        return "redirect:";
    }*/
}
//although you can specify action to redirect POST submissions to different URL,
//you can leave empty, and just have a method for both GET and POST (common practice)