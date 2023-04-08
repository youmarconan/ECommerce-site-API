package com.ecommerce.daos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.models.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    
    Optional<User> findUserByEmailAndPassword(String email, String password);

    public boolean existsByEmail(String email);
}
