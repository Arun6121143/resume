package com.example.hospital.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hospital.model.PatientModel;

public interface IPatientRepo extends JpaRepository<PatientModel, Integer> {

}
