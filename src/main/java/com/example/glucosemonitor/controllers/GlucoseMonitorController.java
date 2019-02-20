package com.example.glucosemonitor.controllers;

import com.example.glucosemonitor.models.GlucoseMonitor;
import com.example.glucosemonitor.models.GlucoseMonitorData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@RequestMapping("gm")
public class GlucoseMonitorController {

    @RequestMapping(value = "") //Views Part 1
    public String index(Model model) {

        model.addAttribute("gmdata", GlucoseMonitorData.getAll());
        model.addAttribute("title", "Glucose Monitor");
        //rather than making static changes to html file, doing this allows for dynamic changes in code
        //meaning I can change title here in code rather than html
        return "gm/index"; //Returns index.html
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddGlucoseMonitorForm(Model model) {
        model.addAttribute("title", "Add Data");
        model.addAttribute("gm", new GlucoseMonitor());
       /* adding the "gm" attribute fixes the Neither BindingResult nor plain target object
        for bean name available as request attribute error*/
        return "gm/add";
    }

    //handler to process the form
    @RequestMapping(value = "add", method = RequestMethod.POST)
    //Within (), this will allow us to get data off of request
    public String processAddGlucoseMonitorForm(@ModelAttribute @Valid GlucoseMonitor newGlucoseMonitor, Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Data");
            model.addAttribute("gm",new GlucoseMonitor());
            //fixes binding issue when sending empty request, but doesn't display error annotations
            return "gm/add";
        }

        GlucoseMonitorData.add(newGlucoseMonitor);

        //Redirect to any root level directory relative to chosen value in @RequestMapping
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