package com.example.laborhiring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.laborhiring.model.Labour;

public interface LabourRepository extends JpaRepository<Labour, Integer> {

    @Query(value = "select * from labour_tbl where email = :email", nativeQuery = true)
    public List<Labour> getByEmailId(String email);

    @Query(value = "select * from labour_tbl where password = :password", nativeQuery = true)
    public List<Labour> getPassword(String password);

    @Query(value = "select * from labour_tbl where email = :email", nativeQuery = true)
    public Labour getByEmailLabourList(String email);

    @Query(value = "select * from labour_tbl where location = :location and skill = :skill", nativeQuery = true)
    public List<Labour> getByLabourList(String location, String skill);

    @Query(value = "select * from labour_tbl where id = :id", nativeQuery = true)
    public Labour getByidLabourList(Integer id);

}
