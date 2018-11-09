package com.realsprint.academy.reactspring.Controllers;

import com.realsprint.academy.reactspring.DAO.UserEntity;
import com.realsprint.academy.reactspring.models.LoginResponse;
import com.realsprint.academy.reactspring.models.User;
import com.realsprint.academy.reactspring.services.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController (UserService userService){
        this.userService = userService;
    }

    @GetMapping("/allusers")
    public List<UserEntity> getAllUsers() {
        return userService.findAllUsers();
    }

    @RequestMapping(value = "/adduser", method = {RequestMethod.POST})
    public LoginResponse update(@RequestBody User user) {
        boolean userAdded = false;
        if (user != null) {
            userAdded = userService.addUser(user);
        }

        if(userAdded){
            String token = getToken(user.getUsername());
            return new LoginResponse(true, token);
        } else {
            return new LoginResponse(false, "");
        }

    }

   @RequestMapping("/name/{username}")
    public UserEntity getUserByName(@PathVariable("name") String username) {
        return userService.findUserByName(username);

    }

    private String getToken(String username){
        Date issuedAt = new Date();
        Date expireAt = new Date(issuedAt.getTime() + TimeUnit.DAYS.toMillis(1));

        String jwtToken = Jwts.builder().setSubject(username).claim("roles", "user").setIssuedAt(issuedAt)
                              .signWith(SignatureAlgorithm.HS256, "secretkey").setExpiration(expireAt).compact();

        return jwtToken;
    }

}
