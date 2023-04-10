package com.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.common.exceptions.AuthenticationException;
import com.ecommerce.common.exceptions.InvalidRequestException;
import com.ecommerce.common.exceptions.IsAlreadyExist;
import com.ecommerce.daos.UserRepo;
import com.ecommerce.models.Credentials;
import com.ecommerce.models.Item;
import com.ecommerce.models.Response;
import com.ecommerce.models.User;

@Service
public class UserService {
    
    private UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User login (Credentials credentials){

        if (credentials == null) {
            throw new InvalidRequestException("The provided credentials object must not be null!");
        }

        if (credentials.getEmail().length() < 4) {
            throw new InvalidRequestException("The provided username must be at least 4 characters!");
        }

        if (credentials.getPassword().length() < 8) {
            throw new InvalidRequestException("The provided password must be at least 8 characters!");
        }

        return userRepo.findUserByEmailAndPassword(credentials.getEmail(), credentials.getPassword()).orElseThrow(AuthenticationException::new);
    }

    public User signUp (User user){

        if (user == null) {
            throw new InvalidRequestException("Provided request must not be null!");
        }

        if (user.getFirstName() == null || user.getFirstName().length() <= 0 ||
                user.getLastName() == null || user.getLastName().length() <= 0) {
            throw new InvalidRequestException("Must provid a first name and a last name!");
        }

        if (user.getEmail() == null || user.getEmail().length() <= 0) {
            throw new InvalidRequestException("Must provid an email!");
        }

        if (user.getPassword() == null || user.getPassword().length() < 8) {
            throw new InvalidRequestException("A password with at least 8 characters must be provided!");
        }

        if (userRepo.existsByEmail(user.getEmail())) {
            throw new IsAlreadyExist("The provided email is already taken.");
        }

        return userRepo.save(user);
    }

    public Response order (Item item){
        return new Response(item.getName() + " has been oerdered");
    }

    
    public List<User> allUsers(){
        return userRepo.findAll();
    }}
