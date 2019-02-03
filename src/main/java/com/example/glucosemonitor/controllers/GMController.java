package com.example.glucosemonitor.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
@RequestMapping("gm") //This is the string you're going to place in the browser (i.e. localhost:8080/gm)
public class GMController {

    static ArrayList<String> cheeses = new ArrayList<>();
    /*We will learn about Static classes but as of now note that this isn't a substitute
    for a database because this ArrayList lives in memory and once session is closed
    it will be erased*/

    //Since I added @RequestMapping at controller level now all subsequent Mappings
    //will be " cheese/ "
    @RequestMapping(value = "") //Views Part 1
    public String index(Model model) {

        model.addAttribute("cheeses", cheeses);

        model.addAttribute("title", "Glucose Monitor");
        //rather than making static changes to html file, doing this allows for dynamic changes in code
        //meaning I can change title here in code rather than html
        return "gm/index"; //Returns index.html
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    //This controller is going to add cheeses instead of hardcoding them
    public String displayAddCheeseForm(Model model){
        model.addAttribute("title", "Add Cheese");
        return "gm/add";
    }

    //handler to process the form
    @RequestMapping(value = "add", method = RequestMethod.POST)
    //Within (), this will allow us to get data off of request
    public String processAddCheeseForm(@RequestParam String cheeseName) {
        //Look at notes regarding this. This is more Springlike
        //cheeseName specifies attribute used in add.html
        cheeses.add(cheeseName);

        //Redirect to any root level directory relative to chosen value in @RequestMapping
        return "redirect:";
    }
}

//although you can specify action to redirect POST submissions to different URL,
//you can leave empty, and just have a method for both GET and POST (common practice)