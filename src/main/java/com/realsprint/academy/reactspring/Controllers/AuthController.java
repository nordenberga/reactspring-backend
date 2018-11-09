package com.realsprint.academy.reactspring.Controllers;

import com.realsprint.academy.reactspring.DAO.UserEntity;
import com.realsprint.academy.reactspring.models.LoginResponse;
import com.realsprint.academy.reactspring.models.User;
import com.realsprint.academy.reactspring.services.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@RestController
public class AuthController {

    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody User login) throws ServletException {
        if (login.getUsername() == null || login.getPassword() == null) {
            return new LoginResponse(false, "Missing username or password.");
        }

        String username = login.getUsername();
        String password = login.getPassword();

        UserEntity entity = userService.findUserByName(username);
        if (entity == null) {
            return new LoginResponse(false, "No user account found");
        }

        if (!password.equals(entity.getPassword())) {
            return new LoginResponse(false, "Username or password incorrect.");
        }

        Date issuedAt = new Date();
        Date expireAt = new Date(issuedAt.getTime() + TimeUnit.DAYS.toMillis(1));

        String jwtToken = Jwts.builder().setSubject(username).claim("roles", "user").setIssuedAt(issuedAt)
                              .signWith(SignatureAlgorithm.HS256, "secretkey").setExpiration(expireAt).compact();

        return new LoginResponse(true, jwtToken);
    }
}
