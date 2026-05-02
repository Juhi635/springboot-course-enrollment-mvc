package com.app.course.controller;

import com.app.course.model.Course;
import com.app.course.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/courses")
public class CourseController {

    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @GetMapping
    public String listCourses(Model model) {
        model.addAttribute("courses", service.getAllCourses());
        return "courses-list";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("course", new Course());
        return "course-form";
    }

    @PostMapping("/save")
    public String saveCourse(@Valid @ModelAttribute Course course,
                             BindingResult result) {
        if (result.hasErrors()) return "course-form";
        service.saveCourse(course);
        return "redirect:/courses";
    }
}
