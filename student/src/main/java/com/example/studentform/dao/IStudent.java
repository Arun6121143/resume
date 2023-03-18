package com.example.studentform.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studentform.model.StudentModel;

public interface IStudent extends JpaRepository<StudentModel,Integer>{
    
}
