package com.realsprint.academy.reactspring.services;

import com.realsprint.academy.reactspring.DAO.UserEntity;
import com.realsprint.academy.reactspring.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepo;



    public List<UserEntity> findAllUsers() {
        return userRepo.findAll();
    }

    public UserEntity findUserById(Long id) {
        return userRepo.getOne(id);
    }

    public void addUser(UserEntity user) {
        userRepo.save(user);

    }
}
