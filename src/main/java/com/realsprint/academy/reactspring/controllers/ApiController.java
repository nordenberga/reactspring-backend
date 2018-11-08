package com.realsprint.academy.reactspring.controllers;

import com.realsprint.academy.reactspring.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

   @GetMapping("/")
   private List<User> getAllUsers() {
      List<User> users = new ArrayList<>();
      users.add(new User("Andreas", "pass"));
      return users;
   }
}
