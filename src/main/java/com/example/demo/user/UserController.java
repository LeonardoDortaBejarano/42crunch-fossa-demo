package com.example.demo.user;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(security = {@SecurityRequirement(name = "DemoSecurityScheme")})
    @GetMapping
    /* @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "OK"),
        @ApiResponse(responseCode = "406", description = "Not Acceptable"),
        @ApiResponse(responseCode = "429", description = "Too Many Requests"),
        @ApiResponse(responseCode = "500", description = "Internal Server Error")
    }) */
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @Operation(security = {@SecurityRequirement(name = "DemoSecurityScheme")})
    @GetMapping("/{id}")
   /*  @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "OK"),
        @ApiResponse(responseCode = "406", description = "Not Acceptable"),
        @ApiResponse(responseCode = "404", description = "Not Found"),
        @ApiResponse(responseCode = "429", description = "Too Many Requests"),
        @ApiResponse(responseCode = "500", description = "Internal Server Error")
    }) */
    public ResponseEntity<UserDto> getUserById(
            @PathVariable
           /*  @Max(value = 999)
            @Min(value = 0) */
            Integer id) {
        UserDto user = userService.getUserById(id);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @Operation(security = {@SecurityRequirement(name = "DemoSecurityScheme")})
    @PostMapping
   /*  @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "OK"),
        @ApiResponse(responseCode = "406", description = "Not Acceptable"),
        @ApiResponse(responseCode = "429", description = "Too Many Requests"),
        @ApiResponse(responseCode = "500", description = "Internal Server Error")
    }) */
    public UserDto createUser(/* @Valid */ @RequestBody UserDto userDto) {
        return userService.saveUser(userDto);
    }

    @Operation(security = {@SecurityRequirement(name = "DemoSecurityScheme")})
    @PutMapping("/{id}")
   /*  @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "OK"),
        @ApiResponse(responseCode = "406", description = "Not Acceptable"),
        @ApiResponse(responseCode = "404", description = "Not Found"),
        @ApiResponse(responseCode = "429", description = "Too Many Requests"),
        @ApiResponse(responseCode = "500", description = "Internal Server Error")
    }) */
    public ResponseEntity<UserDto> updateUser(
            @PathVariable
            /* @Max(value = 999)
            @Min(value = 0) */
            Integer id,
           /*  @Valid */ @RequestBody UserDto userDto) {
        UserDto existingUser = userService.getUserById(id);
        if (existingUser == null) {
            return ResponseEntity.notFound().build();
        }
        userDto.setUsername(userDto.getUsername());
        return ResponseEntity.ok(userService.saveUser(userDto));
    }

    @Operation(security = {@SecurityRequirement(name = "DemoSecurityScheme")})
    @DeleteMapping("/{id}")
    /* @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "No Content"),
        @ApiResponse(responseCode = "406", description = "Not Acceptable"),
        @ApiResponse(responseCode = "404", description = "Not Found"),
        @ApiResponse(responseCode = "429", description = "Too Many Requests"),
        @ApiResponse(responseCode = "500", description = "Internal Server Error")
    }) */
    public ResponseEntity<Void> deleteUser(
        @PathVariable
        /* @Max(value = 999)
        @Min(value = 0) */
        Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
