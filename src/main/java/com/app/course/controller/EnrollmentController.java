package com.app.course.controller;

import com.app.course.model.Enrollment;
import com.app.course.service.CourseService;
import com.app.course.service.EnrollmentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/enrollments")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;
    private final CourseService courseService;

    public EnrollmentController(EnrollmentService e, CourseService c) {
        this.enrollmentService = e;
        this.courseService = c;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("list", enrollmentService.getAllEnrollments());
        return "enrollment-list";
    }

    @GetMapping("/new")
    public String form(Model model) {
        model.addAttribute("enrollment", new Enrollment());
        model.addAttribute("courses", courseService.getAllCourses());
        return "enrollment-form";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute Enrollment enrollment,
                       BindingResult result,
                       Model model) {

        if (result.hasErrors()) {
            model.addAttribute("courses", courseService.getAllCourses());
            return "enrollment-form";
        }

        enrollmentService.saveEnrollment(enrollment);
        return "redirect:/enrollments";
    }
}
