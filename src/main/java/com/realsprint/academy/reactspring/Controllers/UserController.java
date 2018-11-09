package com.realsprint.academy.reactspring.Controllers;

import com.realsprint.academy.reactspring.DAO.UserEntity;
import com.realsprint.academy.reactspring.models.User;
import com.realsprint.academy.reactspring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController

public class UserController {


    @Autowired
    UserService userService;

    @GetMapping("/allusers")
    public List<UserEntity> getAllUsers() {
        return userService.findAllUsers();
    }


    @RequestMapping(value = "/adduser", method = {RequestMethod.POST})//, produces={MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<User> update(@RequestBody User user) {

        if (user != null) {
            userService.addUser(user);

        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }



}
