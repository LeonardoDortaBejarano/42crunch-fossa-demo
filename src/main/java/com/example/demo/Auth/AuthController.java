package com.example.demo.Auth;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.user.User;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import jakarta.validation.Valid;

import java.util.Optional;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("auth")


public class AuthController {

    @Autowired
    private AuthService authService;

    public AuthController() {
    }

    @PostMapping("login")
    public ResponseEntity<AuthReponse> login(@RequestBody @Valid LoginRequest loginRequest) {
        String token = this.authService.login(loginRequest); 
        if (token != null) {
            return new ResponseEntity<AuthReponse>(new AuthReponse(token), HttpStatus.OK);
        }       
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("register")
    public ResponseEntity<AuthReponse> register(@RequestBody @Valid RegisterRequest registerRequest) {
        String token = this.authService.register(registerRequest);        
        return new ResponseEntity<AuthReponse>(new AuthReponse(token), HttpStatus.OK);
    }
    



}
