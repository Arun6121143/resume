package com.example.laborhiring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.laborhiring.model.Labour;
import com.example.laborhiring.repository.LabourRepository;

@Service
public class LabourService {

    @Autowired
    LabourRepository lRepo;

    public void addLabour(Labour details) {
        lRepo.save(details);
    }

}
