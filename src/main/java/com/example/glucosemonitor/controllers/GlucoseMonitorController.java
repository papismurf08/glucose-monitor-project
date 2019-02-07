package com.example.glucosemonitor.controllers;

import com.example.glucosemonitor.models.GlucoseMonitor;
import com.example.glucosemonitor.models.GlucoseMonitorData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("gm") //This is the string you're going to place in the browser (i.e. localhost:8080/gm)
public class GlucoseMonitorController {

    @RequestMapping(value = "") //Views Part 1
    public String index(Model model) {

        model.addAttribute("gmdata", GlucoseMonitorData.getAll());

        model.addAttribute("title", "My Glucose Monitor Data");
        //rather than making static changes to html file, doing this allows for dynamic changes in code
        //meaning I can change title here in code rather than html
        return "gm/index"; //Returns index.html
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    //This controller is going to add cheeses instead of hardcoding them
    public String displayAddGlucoseMonitorForm(Model model){
        model.addAttribute("title", "Add GlucoseMonitor");
        model.addAttribute(new GlucoseMonitor());
        return "gm/add";
    }

    //handler to process the form
    @RequestMapping(value = "add", method = RequestMethod.POST)
    //Within (), this will allow us to get data off of request
    public String processAddGlucoseMonitorForm(@ModelAttribute @Valid GlucoseMonitor newGlucoseMonitor, Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add GlucoseMonitor");
            return "gm/add";
        }

        GlucoseMonitorData.add(newGlucoseMonitor);

        //Redirect to any root level directory relative to chosen value in @RequestMapping
        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveGlucoseMonitorForm(Model model) {
        model.addAttribute("gmdata", GlucoseMonitorData.getAll());
        model.addAttribute("title", "Remove GlucoseMonitor");
        return "gm/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveCheeseForm(@RequestParam int[] gmIds) {

        for (int gmId : gmIds) {

            GlucoseMonitorData.remove(gmId);
        }

        return "redirect:";
    }

    @RequestMapping(value = "/gm/chart", method=RequestMethod.GET)
    public String chart(Model model) {

        //First Part, dummy code placed here w/values hardcoded
        Integer glucose = 100;
        Integer bloodpressure = 100;
        Integer weight = 100;

        model.addAttribute("glucose", glucose);
        model.addAttribute("bloodpressure", bloodpressure);
        model.addAttribute("weight", weight);

        //now add integers by type
        List<Integer> placeholder1 = Arrays.asList(4074, 3455, 4112);
        List<Integer> placeholder2 = Arrays.asList(3222, 3011, 3788);
        List<Integer> placeholder3 = Arrays.asList(7811, 7098, 6455);

        model.addAttribute("placeholder1", placeholder1);
        model.addAttribute("placeholder2", placeholder2);
        model.addAttribute("placeholder3", placeholder3);

        return "chart";
    }

    @RequestMapping("/")
    public String home(Model model) {
        return "redirect:chart";
    }
}

//although you can specify action to redirect POST submissions to different URL,
//you can leave empty, and just have a method for both GET and POST (common practice)