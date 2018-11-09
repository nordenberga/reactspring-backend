package com.realsprint.academy.reactspring.services;

import com.realsprint.academy.reactspring.DAO.UserEntity;
import com.realsprint.academy.reactspring.Repositories.UserRepository;
import com.realsprint.academy.reactspring.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserService {

    private UserRepository userRepo;

    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public List<UserEntity> findAllUsers() {
        return userRepo.findAll();
    }

    public UserEntity findUserById(Long id) {
        return userRepo.getOne(id);
    }

    public UserEntity findUserByName(String name) {
        return userRepo.findByUsername(name);
    }

    public boolean addUser(User user) {
        if(findUserByName(user.getUsername()) != null){
            return false;
        }
        UserEntity newUser = new UserEntity();

        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        userRepo.save(newUser);
        return true;
    }

}
