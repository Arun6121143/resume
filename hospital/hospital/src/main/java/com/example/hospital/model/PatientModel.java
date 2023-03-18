package com.example.hospital.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pat_tbl")
public class PatientModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pat_id")
    private Integer patId;
    @Column(name = "pat_name")
    private String patName;
    @Column(name = "pat_add")
    private String patAddress;
    @Column(name = "pat_num")
    private String patNum;
    @Column(name = "pat_concern")
    private String patConcern;

    @JoinColumn(name = "doc_id")
    @ManyToOne
    private DoctorModel doctor;

}
