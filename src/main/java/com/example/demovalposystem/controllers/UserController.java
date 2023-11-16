package com.example.demovalposystem.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demovalposystem.models.UserModel;
import com.example.demovalposystem.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping()
    public ArrayList<UserModel> getUsers() {
        return userService.getUsers();
    }

    @PostMapping()
    public UserModel addUser(@RequestBody UserModel user) {
        return this.userService.saveUser(user);
    }

    @GetMapping( path = "/{id}")
    public Optional<UserModel> getUserById(@PathVariable("id") Long id) {
        return this.userService.getUserById(id);
    }

    @DeleteMapping( path = "/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
        boolean ok = this.userService.deleteUser(id);
        if(ok) {
            return new ResponseEntity<>("User " + id + " has been delete", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("User " + id + " could not be delete", HttpStatus.CONFLICT);
        }
    }
}
