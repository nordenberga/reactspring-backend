package com.realsprint.academy.reactspring.restControllers;


import com.realsprint.academy.reactspring.models.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping("/newUser")
    public void createNewUser(@RequestBody User newUser){

    }
}
