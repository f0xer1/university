package com.example.lab4.web;

import com.example.lab4.entity.Student;
import com.example.lab4.service.FacultyService;
import com.example.lab4.service.StudentService;
import com.example.lab4.service.UniversityService;
import com.example.lab4.task.Task;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/task")
public class TaskController {

    @Autowired
    UniversityService universityService;
    @Autowired
    FacultyService facultyService;
    @Autowired
    StudentService studentService;

    @GetMapping("/")
    public String getChooseUniversityForm(Model model) {
        model.addAttribute("universities", universityService.getUniversities());
        return "task";
    }

    @PostMapping("/chooseFaculty")
    public String chooseUniversity(@RequestParam(required = false) String universityId,
                                   @RequestParam(required = false) String tasks,
                                   Model model, RedirectAttributes redirectAttributes) {
       if (universityId.equals("Choose University")) {
                redirectAttributes.addFlashAttribute("error", "Виникла помилка, виберіть університет");
                return "redirect:/task/";
        }else {
           model.addAttribute("result", Task.doTask(universityService.getUniversityById(universityId), tasks));
           model.addAttribute("universities", universityService.getUniversities());
           return "task";
       }

    }
}

