package com.app.copilot.RentWheelz.controller;

//this is user controller
//this class will have all the user related end points

import com.app.copilot.RentWheelz.dto.LoginDto;
import com.app.copilot.RentWheelz.dto.UserDto;
import com.app.copilot.RentWheelz.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    //this method will register user
    //this method will take user object as input
    //this method will return user object
    //this method will have post mapping
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto createdUser = userService.createUser(userDto);
        return ResponseEntity.ok(createdUser);
    }

    //this method will get user by email
//this method will take email as input
    //this method will return user object
    //this method will have get mapping
    @GetMapping("/{email}")
    public ResponseEntity<UserDto> getUserByEmail(@PathVariable String email) {
        UserDto user = userService.getUser(email);
        return ResponseEntity.ok(user);
    }

    //this method will get all users
    //this method will return list of user objects
    //this method will have get mapping
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    //this method will update user
    //this method will take user object as input
    //this method will return user object
    //this method will have put mapping


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
        boolean isAuthenticated = userService.authenticateUser(loginDto.getEmail(), loginDto.getPassword());
        if (isAuthenticated) {
            return ResponseEntity.ok("User authenticated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
    }
    @PutMapping
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto) {
        UserDto updatedUser = userService.updateUser(userDto.getUserEmail(),userDto);
        return ResponseEntity.ok(updatedUser);
    }

    //this method will delete user by email
    //this method will take email as input
    //this method will return string
    //this method will have delete mapping
    @DeleteMapping("/{email}")
    public ResponseEntity<String> deleteUserByEmail(@PathVariable String email) {
        String response = userService.deleteUser(email);
        return ResponseEntity.ok(response);
    }



}
