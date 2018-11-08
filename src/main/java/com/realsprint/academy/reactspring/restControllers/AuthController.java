package com.realsprint.academy.reactspring.restControllers;

import com.realsprint.academy.reactspring.models.LoginResponse;
import com.realsprint.academy.reactspring.models.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@RestController
public class AuthController {
    @PostMapping("/login")
    public LoginResponse login(@RequestBody User login) throws ServletException {
        if (login.getUsername() == null || login.getPassword() == null) {
            return new LoginResponse(false, "Missing username or password.");
        }

        String username = login.getUsername();
        String password = login.getPassword();

        if (!password.equals("pass")) {
            return new LoginResponse(false, "Username or password incorrect.");
        }

        Date issuedAt = new Date();
        Date expireAt = new Date(issuedAt.getTime() + TimeUnit.SECONDS.toMillis(1000));

        String jwtToken = Jwts.builder().setSubject(username).claim("roles", "user").setIssuedAt(issuedAt)
                .signWith(SignatureAlgorithm.HS256, "secretkey").setExpiration(expireAt).compact();

        return new LoginResponse(true, jwtToken);
    }
}
