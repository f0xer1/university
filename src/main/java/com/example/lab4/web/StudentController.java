package com.example.lab4.web;

import com.example.lab4.entity.Student;
import com.example.lab4.service.FacultyService;
import com.example.lab4.service.StudentService;
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
@RequestMapping("/student")
public class StudentController {
    @Autowired
    UniversityService universityService;
    @Autowired
    FacultyService facultyService;
    @Autowired
    StudentService studentService;

    @GetMapping("/")
    public String getChooseUniversityForm(Model model) {
        model.addAttribute("universities", universityService.getUniversities());
        model.addAttribute("student", studentService.createStudent());
        return "student";
    }

    @PostMapping("/chooseFaculty")
    public String chooseUniversity(@Valid Student student, BindingResult result,
                                   @RequestParam(required = false) String universityId,
                                   @RequestParam(required = false) String facultyId,
                                   Model model, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()){

            model.addAttribute("universities", universityService.getUniversities());
            model.addAttribute("student", student);
            return "student";
        } else if (universityId.equals("Choose University")) {
            redirectAttributes.addFlashAttribute("error", "Виникла помилка, виберіть університет");
            return "redirect:/student/";
        } else {
            if (facultyId != null) {
                facultyService.addStudentToFaculty(facultyId, universityService.getUniversityById(universityId), student);
                redirectAttributes.addFlashAttribute("success", "Студент був успішно доданий.");
                return "redirect:/student/";
            } else {
                model.addAttribute("faculties", universityService.getFacultiesByUniversity(
                        universityService.getUniversityById(universityId)));
                model.addAttribute("universityId", universityId);
                model.addAttribute("universities", universityService.getUniversityById(universityId));
                return "student";
            }
        }
    }
}



