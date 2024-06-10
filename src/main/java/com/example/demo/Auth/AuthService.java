package com.example.demo.Auth;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Jwt.JwtService;
import com.example.demo.user.User;
import com.example.demo.user.UserRepository;

@Service
public class AuthService {
    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public String login(LoginRequest loginRequest) {  
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        Optional<User> user = this.userRepository.findByUsername(loginRequest.getUsername());
        if (user.isPresent()) {
            return jwtService.generateToken(user.get(),user.get().getUserID());
        } else {
           return null;
        }
        
    }

    public String register(RegisterRequest registerRequest) {
        
        User user = new User();
        user.setEmail(registerRequest.getEmail());
        user.setUsername(registerRequest.getUsername());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        this.userRepository.save(user);
        return jwtService.generateToken(user,user.getUserID());
    }

}
