package com.example.studentform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentform.dao.IStudent;
import com.example.studentform.model.StudentModel;
@Service
public class StudentService {

    @Autowired
    IStudent stdRepo;

    public void addStudent(StudentModel model) {
       stdRepo.save(model);
    }
    
}
