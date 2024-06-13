package com.example.demo.Auth;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class LoginRequest {
    
    @Schema(description = "Username.", required = true, example = "test")
    private String username;

    @Schema(description = "Password.", required = true, example = "test")
    private String password;

    public LoginRequest() {
    }
    
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }



    

}
