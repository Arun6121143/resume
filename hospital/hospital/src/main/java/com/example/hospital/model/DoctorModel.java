package com.example.hospital.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "doc_tbl")
public class DoctorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doc_id")
    private Integer docId;
    @Column(name = "doc_name")
    private String docName;
    @Column(name = "doc_spec")
    private String specialization;
    @Column(name = "doc_exp")
    private Integer experience;
    @Column(name = "doc_phNum")
    private String phNum;

}
