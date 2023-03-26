package com.example.laborhiring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.laborhiring.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "select * from user_tbl where email = :email", nativeQuery = true)
    public List<User> getByEmailUser(String email);

    @Query(value = "select * from user_tbl where email = :email", nativeQuery = true)
    public User getByEmailUserList(String email);

}
