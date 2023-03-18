package com.example.studentform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.studentform.dao.IStudent;
import com.example.studentform.model.StudentModel;
import com.example.studentform.service.StudentService;

@Controller
public class StudentController {

   
    @Autowired
    StudentService service;

    @Autowired
    IStudent repo;

    @GetMapping("/")
    // @PreAuthorize("hasAuthority('USER')")
    public String dashBoard() {
        return "dashBoard";
    }

    @PostMapping("/student")
    public String addStudent(@ModelAttribute StudentModel model) {
        service.addStudent(model);
        return "redirect:/";
    }

    @GetMapping("/get/StudentId/{StudentId}")
    @ResponseBody
    public StudentModel getStudentMarks(@PathVariable Integer StudentId) {
        return repo.findById(StudentId).get();
    }

    

}
