package com.example.lab4.web;

import com.example.lab4.entity.University;
import com.example.lab4.service.UniversityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UniversityController {
    @Autowired
    UniversityService service;
    @GetMapping("/")
    public String  getUniversityForm(Model model) {
        model.addAttribute("university",service.createUniversity());
        return "university";
    }
    @PostMapping("/createUniversity")
    public String submitUniversityForm(@Valid University university, BindingResult result, RedirectAttributes redirectAttributes){
        if (result.hasErrors()) {
            return "university";
        } else {
            if (service.verificationUniquenessUniversity(university)){
                redirectAttributes.addFlashAttribute("error", "Такий університет вже існує");
                return "redirect:/";
            }
            else {
                service.addUniversity(university);
                redirectAttributes.addFlashAttribute("success", "Університет був успішно створений.");
                return "redirect:/";
            }

        }
    }

}
