package com.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.models.Credentials;
import com.ecommerce.models.Item;
import com.ecommerce.models.Response;
import com.ecommerce.models.User;
import com.ecommerce.services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200/", allowCredentials = "true")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> allUsers(){
        return ResponseEntity.ok(userService.allUsers());
    }

    
    @PostMapping(value = "/signup")
    public ResponseEntity<User> signUp(@RequestBody User user) {

        return ResponseEntity.ok().body(userService.signUp(user));
    }

    @PostMapping(value = "/login")
    public ResponseEntity<User> login(@RequestBody Credentials credentials) {

        return ResponseEntity.ok().body(userService.login(credentials));
    }

    @PostMapping(value = "/order")
    public ResponseEntity<Response> order(@RequestBody Item item) {
        return ResponseEntity.ok(userService.order(item));
    }
}
