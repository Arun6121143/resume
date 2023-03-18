package com.example.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hospital.model.DoctorModel;
import com.example.hospital.service.DoctorService;

@RestController
@RequestMapping("/Hospital/Doctor")
public class DoctorController {

  @Autowired
  DoctorService service;

  @PostMapping("/addDoc")
  public String addDoctor(@RequestBody DoctorModel doctor) {
   return  service.saveDoc(doctor);
    
  }

  @GetMapping("/GetDoctor/Details")
  public List<DoctorModel> GetDoc(DoctorModel doctor) {
    return service.getDoc(doctor);
  }

  @GetMapping("/GetDoctor/Details/docId/{docId}")
  public DoctorModel GetDoc(@PathVariable Integer docId) {
    return service.getDocById(docId);
  }

  @PutMapping("Update/Doctor/docId/{docId}")
  public String updateDoc(@PathVariable Integer docId, @RequestBody DoctorModel newDoc) {
    service.updateDoc(docId, newDoc);
    return "Doctor details Updated";
  }

  @DeleteMapping("Delete/Doctor/docId/{docId}")
  public String deleteDoc(@PathVariable Integer docId) {
    service.deleteById(docId);
    return "Deleted the doctor with id =" + docId;
  }
}
