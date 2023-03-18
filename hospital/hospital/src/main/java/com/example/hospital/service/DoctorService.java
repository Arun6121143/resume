package com.example.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospital.dao.IDocRepo;
import com.example.hospital.model.DoctorModel;

@Service
public class DoctorService {

    @Autowired
    IDocRepo docrepo;

    public String saveDoc(DoctorModel doctor) {
        if(doctor.getPhNum().length()==10){
        docrepo.save(doctor);
        return "saved";
        }else{
           return "Incorrect Phone number";
        }
    }

    public List<DoctorModel> getDoc(DoctorModel doctor) {
        return docrepo.findAll();
    }

    public DoctorModel getDocById(Integer docId) {
        return docrepo.findById(docId).get();
    }

    public void updateDoc(Integer docId, DoctorModel newDoc) {
        DoctorModel newDoctor = docrepo.findById(docId).get();

        newDoctor.setDocName(newDoc.getDocName());
        newDoctor.setExperience(newDoc.getExperience());
        newDoctor.setPhNum(newDoc.getPhNum());
        newDoctor.setSpecialization(newDoc.getSpecialization());

        docrepo.save(newDoctor);
    }

    public void deleteById(Integer docId) {
        docrepo.deleteById(docId);
    }
}
