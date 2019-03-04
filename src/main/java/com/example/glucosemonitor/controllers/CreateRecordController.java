package com.example.glucosemonitor.controllers;

import com.example.glucosemonitor.data.UserRepository;
import com.example.glucosemonitor.models.CreateRecord;
import com.example.glucosemonitor.models.Category;
import com.example.glucosemonitor.data.CreateRecordRepository;
import com.example.glucosemonitor.data.CategoryRepository;

import com.example.glucosemonitor.models.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/create")
@SessionAttributes("category")
@Slf4j
public class CreateRecordController {

    @Autowired
    private CreateRecordRepository createRecordRepo;

    @Autowired
    private CategoryRepository categoryRepo;

    @Autowired
    private UserRepository userRepo;

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("stats", createRecordRepo.findAll());
        model.addAttribute("title", "Glucose Monitor");

        return "create/index";
    }

    @GetMapping("add")
    public String displayAddForm(Model model) {
        model.addAttribute("title", "Create Record");
        model.addAttribute("create", new CreateRecord());
        model.addAttribute("categories", categoryRepo.findAll());

        /*String username = principal.getName();
        User user = userRepo.findByUsername(username);
        model.addAttribute("user", user);*/

        return "create/add";
    }

    @PostMapping("add")
    /*public String processAddForm(@ModelAttribute("create")  @Valid  CreateRecord newRecord, Errors errors,
                                       @RequestParam Long categoryId,
                                       Model model) {*/
    public String processAddForm(@ModelAttribute("create")  @Valid  CreateRecord newRecord, Errors errors,
                                  Long categoryId , Model model) {
        /*If I add @RequestParam("categoryId", required = false), this doesn't automatically throw the error when I
        hit the submit button, but when I input the values and then submit I get the error*/

        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Record");
            return "create/add";
        }
        //Category cat = categoryRepo.findById(category.getId()).orElse(null);
        Category cat = categoryRepo.findById(categoryId).orElse(null);
        //if I don't add .orElse(null) I get incompatible types because findbyId returns an Optional instead of null
        newRecord.setCategory(cat);
        createRecordRepo.save(newRecord);
        return "redirect:";
    }

    @GetMapping("remove")
    public String displayRemoveForm(Model model) {
        model.addAttribute("stats", createRecordRepo.findAll());
        //model.addAttribute("title", "Remove Cheese");
        return "create/remove";
    }

    @PostMapping("remove")
    public String processRemoveForm(@RequestParam Long[] createIds) {

        for (Long createId : createIds) {
            createRecordRepo.deleteById(createId);
        }

        return "redirect:";
    }

    /*@DeleteMapping("/{orderId}")
    @ResponseStatus(code= HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable("orderId") Long orderId) {
        try {
            repo.deleteById(orderId);
        } catch (EmptyResultDataAccessException e) {}
    }
*/
    //@RequestMapping(value = "category/{categoryId}", method = RequestMethod.GET)
    @GetMapping("category/{categoryId}")
    public String category(Model model, @PathVariable Long categoryId) {
        model.addAttribute("stats", categoryRepo.findById(categoryId).orElse(null).getStats());
        model.addAttribute("title", "My Info");
        return "create/index";
    }

    //@RequestMapping(value = "edit/{cheeseId}", method = RequestMethod.GET)
    @GetMapping("edit/{createId}")
    public String displayEditForm(Model model, @PathVariable Long createId) {
        //User userFromSession = getUserFromSession(request);
        model.addAttribute("create", createRecordRepo.findById(createId).orElse(null));
        model.addAttribute("categories", categoryRepo.findAll());

        return "create/edit";
    }

    //@RequestMapping(value = "edit", method = RequestMethod.POST)
    @PostMapping("edit")
    public String processEditForm(@RequestParam Long createId, @RequestParam String createGlucose,
                                  @RequestParam String createInsulin, @RequestParam String createCarbs,
                                  @RequestParam String createNote, @RequestParam long categoryId){
    //public String processEditForm{@PathVariable(value = "createId") int createId, @PathVariable(value = "")
        CreateRecord create = createRecordRepo.findById(createId).orElse(null);
        Category category = categoryRepo.findById(categoryId).orElse(null);

        /*create.setGlucose("glucose");
        create.setInsulin("insulin");
        create.setCarbs("carbs");
        create.setNote("note");
        create.setCategory(category);*/

        create.setGlucose(createGlucose);
        create.setInsulin(createInsulin);
        create.setCarbs(createCarbs);
        create.setNote(createNote);
        create.setCategory(category);

        createRecordRepo.save(create);

        return "redirect:";
    }

}
