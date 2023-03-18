package com.example.studentform.model;


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
@Table(name = "student_marks")
public class StudentMarksSheet {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer marksId;
    private Integer physics;
    private Integer Chemistry;
    private Integer CAD;
    private Integer Mathematics;
    private Integer DE;
    @JoinColumn(name = "student_id")
    @ManyToOne
    private StudentModel studentId;
   
}
