package com.realsprint.academy.reactspring.Controllers;

import com.realsprint.academy.reactspring.DAO.UserEntity;
import com.realsprint.academy.reactspring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/adduser/{username}/{password}")
    public List<UserEntity> getMoviesFromService(@PathVariable String username, @PathVariable String password) {
        userService.addUser(new UserEntity(username, password));
        return userService.findAllUsers();
    }

   /* @PostMapping("/addmovie")
    public ModelAndView addNewMovieFromForm(@RequestParam String title, @RequestParam int year) {
        movieService.addMovie(new Movie(title, year));
        return new ModelAndView("view").addObject("movies", movieService.getMovies());
    }*/

}
