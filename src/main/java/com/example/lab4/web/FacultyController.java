package com.example.lab4.web;

import com.example.lab4.entity.Faculty;
import com.example.lab4.entity.University;
import com.example.lab4.service.FacultyService;
import com.example.lab4.service.UniversityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/faculty")
public class FacultyController {
    @Autowired
    FacultyService facultyService;
    @Autowired
    UniversityService universityService;

    @GetMapping("/")
    public String getFacultyForm(Model model) {
        model.addAttribute("faculty", facultyService.createFaculty());
        model.addAttribute("universities", universityService.getUniversities());
        return "faculty";
    }

    @PostMapping("/addFacultyToUniversity")
    public String submitFacultyToUniversity(@Valid Faculty faculty, BindingResult result, Model model,
                                            @RequestParam(required = false) String universityId,
                                            RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            model.addAttribute("faculty", faculty);
            model.addAttribute("universities", universityService.getUniversities());
            return "faculty";
        } else if (universityId.equals("Choose University")) {
            redirectAttributes.addFlashAttribute("error", "Виникла помилка, виберіть університет");
            return "redirect:/faculty/";
        }else {
            if (facultyService.verificationUniquenessFaculty(faculty, universityId)) {
                redirectAttributes.addFlashAttribute("error", "Виникла помилка.");
                return "redirect:/faculty/";
            } else {
                universityService.addFacultyToUniversity(universityId, faculty);
                redirectAttributes.addFlashAttribute("success", "Факультет був успішно доданий.");
                return "redirect:/faculty/";
            }

        }
    }
}
