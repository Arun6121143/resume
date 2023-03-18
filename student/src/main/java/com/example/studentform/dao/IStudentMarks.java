package com.example.studentform.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studentform.model.StudentMarksSheet;

public interface IStudentMarks extends JpaRepository<StudentMarksSheet,Integer> {
    
}
