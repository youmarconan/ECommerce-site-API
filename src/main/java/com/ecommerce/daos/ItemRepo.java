package com.ecommerce.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.models.Item;

@Repository
public interface ItemRepo extends JpaRepository<Item,Integer>{
    
}
