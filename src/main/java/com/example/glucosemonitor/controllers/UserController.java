package com.example.glucosemonitor.controllers;

import com.example.glucosemonitor.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute(new User());
        model.addAttribute("title", "Register");
        return "user/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(String verify, Model model, @ModelAttribute @Valid User user, Errors errors)
    //String cannot be placed last or else it will show in red
    {

        model.addAttribute(user);
        boolean passwordsMatch = true;
        if (user.getPassword() == null || verify == null || !user.getPassword().equals(verify)) {
            passwordsMatch = false;
            model.addAttribute("verifyError", "Passwords must match");
        }

        if (!errors.hasErrors() && passwordsMatch) {
            return "user/index";

        }

        return "user/add";
    }
}

