package com.example.glucosemonitor.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.extern.slf4j.Slf4j;
import com.example.glucosemonitor.models.Loggy;
import com.example.glucosemonitor.models.Loggy.Type;
import com.example.glucosemonitor.models.Display;
import com.example.glucosemonitor.models.Record;
import com.example.glucosemonitor.models.User;
import com.example.glucosemonitor.data.LoggyRepository;
import com.example.glucosemonitor.data.RecordRepository;
import com.example.glucosemonitor.data.UserRepository;

@Controller
@RequestMapping("/create")
@SessionAttributes("display")
@Slf4j
public class CreateRecordController {

    private final LoggyRepository loggyRepo;

    private RecordRepository recordRepo;

    private UserRepository userRepo;

    @Autowired
    public CreateRecordController(
            LoggyRepository loggyRepo,
            RecordRepository recordRepo,
            UserRepository userRepo) {
        this.loggyRepo = loggyRepo;
        this.recordRepo = recordRepo;
        this.userRepo = userRepo;
    }

    @ModelAttribute(name = "display")
    public Display display() {
        return new Display();
    }

    @ModelAttribute(name = "create")
    public Record design() {
        return new Record();
    }

    @GetMapping
    public String showDesignForm(Model model, Principal principal) {
        log.info("   --- Designing record");
        List<Loggy> logs = new ArrayList<>();
        loggyRepo.findAll().forEach(i -> logs.add(i));

        Type[] types = Loggy.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(logs, type));
        }

        String username = principal.getName();
        User user = userRepo.findByUsername(username);
        model.addAttribute("user", user);

        return "design";
    }

    @PostMapping
    public String processDesign(
    @Valid Record record, Errors errors,
    @ModelAttribute Display display) {

        log.info("   --- Saving record");

        if (errors.hasErrors()) {
            return "design";
        }

        Record saved = recordRepo.save(record);
        display.addDesign(saved);

        return "redirect:/display/current";
    }

    private List<Loggy> filterByType(
            List<Loggy> logs, Type type) {
        return logs
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}
