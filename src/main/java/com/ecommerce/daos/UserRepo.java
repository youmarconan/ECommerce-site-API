package com.ecommerce.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.models.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    
    public User findUserByEmailAndPassword(String email, String password);
}
