package com.example.laborhiring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.laborhiring.model.User;
import com.example.laborhiring.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository uRepo;

    public void adduser(User user) {
        uRepo.save(user);
    }

}
