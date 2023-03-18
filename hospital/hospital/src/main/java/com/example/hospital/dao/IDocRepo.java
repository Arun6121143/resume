package com.example.hospital.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hospital.model.DoctorModel;

public interface IDocRepo extends JpaRepository<DoctorModel,Integer> {
    
}
