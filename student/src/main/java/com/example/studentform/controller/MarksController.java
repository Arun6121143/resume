package com.example.studentform.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.studentform.dao.IStudent;
import com.example.studentform.dao.IStudentMarks;
import com.example.studentform.model.StudentMarksSheet;
import com.example.studentform.service.StudentMarksService;

@Controller
public class MarksController {

    @Autowired
    StudentMarksService service;

    @Autowired
    IStudentMarks repo;

    @Autowired
    IStudent srepo;

    @GetMapping("/admin") // Authorized only to admin
    @PreAuthorize("hasAuthority('ADMIN')")
    public String adminDashBoard() {
        return "admindashBoard";
    }

    @PostMapping("/post/admin")
    public String addMarks(@ModelAttribute StudentMarksSheet marks) {
        repo.save(marks);
        return "redirect:/admin";
    }

    @GetMapping("/get/marksId/{marksId}") // Permit All
    @ResponseBody
    public StudentMarksSheet getStudentMarks(@PathVariable Integer marksId) {
        return repo.findById(marksId).get();
    }

    @GetMapping("/mark")
    // @PreAuthorize("hasAuthority('USER')")
    public String dashBoard() {
        return "marks";
    }

    @PostMapping("/marks")
    public String submitMarksForm(@ModelAttribute("mark") StudentMarksSheet mark, Model model) {
        try {
            StudentMarksSheet marks = repo.findById(mark.getMarksId()).get();
            model.addAttribute("marks", marks);
            return "marks-result";
        } catch (Exception e) {
            return "notFound";
        }

    }

    //main college Portal api
    @GetMapping("/College-Page")
    public String mainPage() {
        return "mainPage";
    }

}
