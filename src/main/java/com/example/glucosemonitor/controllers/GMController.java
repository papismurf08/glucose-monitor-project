package com.example.glucosemonitor.controllers;

import com.example.glucosemonitor.models.GMData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;

import com.example.glucosemonitor.models.GlucoseMonitor;

@Controller
@RequestMapping("gm") //This is the string you're going to place in the browser (i.e. localhost:8080/gm)
public class GMController {

    @RequestMapping(value = "") //Views Part 1
    public String index(Model model) {

        model.addAttribute("cheeses", GMData.getAll());

        model.addAttribute("title", "Glucose Monitor");
        //rather than making static changes to html file, doing this allows for dynamic changes in code
        //meaning I can change title here in code rather than html
        return "gm/index"; //Returns index.html
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    //This controller is going to add cheeses instead of hardcoding them
    public String displayAddCheeseForm(Model model){

        model.addAttribute(new GlucoseMonitor());
        model.addAttribute("title", "GlucoseMonitor");
        return "gm/add";
    }

    //handler to process the form
    @RequestMapping(value = "add", method = RequestMethod.POST)
    //Within (), this will allow us to get data off of request
    public String processAddCheeseForm(@ModelAttribute @Valid GlucoseMonitor newCheese, Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Cheese");
            return "gm/add";
        }

        GMData.add(newCheese);

        //Redirect to any root level directory relative to chosen value in @RequestMapping
        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveCheeseForm(Model model) {
        model.addAttribute("cheeses", GMData.getAll());
        model.addAttribute("title", "Remove Cheese");
        return "gm/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveCheeseForm(@RequestParam int[] cheeseIds) {

        for (int cheeseId : cheeseIds) {

            GMData.remove(cheeseId);
        }

        return "redirect:";
    }
}

//although you can specify action to redirect POST submissions to different URL,
//you can leave empty, and just have a method for both GET and POST (common practice)