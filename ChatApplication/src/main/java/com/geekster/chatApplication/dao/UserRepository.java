package com.geekster.chatApplication.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.geekster.chatApplication.model.Users;

public interface UserRepository extends JpaRepository<Users,Integer> {

    @Query(value="select * from tbl_user where username = :username and status_id=1", nativeQuery=true)
    public List<Users> findByUsername(String username);

    @Query(value = "select * from tbl_user where user_id = :userId and status_id = 1", nativeQuery = true)
    public List<Users> getUserByUserId(int userId);

    @Query(value = "select * from tbl_user where status_id = 1", nativeQuery = true)
    public List<Users> getAllUsers();
}

