package com.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return userRepo.findUserByEmailAndPassword(credentials.getEmail(), credentials.getPassword());
    }

    public User signUp (User user){
        return userRepo.save(user);
    }

    public Response order (Item item){
        return new Response(item.getName() + " has been oerdered");
    }
}
