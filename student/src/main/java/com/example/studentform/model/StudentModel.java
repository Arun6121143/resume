package com.example.studentform.model;

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
@Table(name = "student_tbl")
public class StudentModel {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name ="student_id")
    private Integer StudentId;
    private String firstName;
    private String lastName;
    private String branch;
    private String currentYear;
    private String phNum;
   
   
}
