package com.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.daos.ItemRepo;
import com.ecommerce.models.Item;

@RestController
@RequestMapping("/item")
@CrossOrigin(origins="http://localhost:4200/", allowCredentials="true")
public class ItemController {
    
    private final ItemRepo itemRepo;

    @Autowired
    public ItemController(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    @PostMapping
    public ResponseEntity <Item> addItem(Item item){
        return ResponseEntity.ok(itemRepo.save(item));
    }

    @GetMapping
    public ResponseEntity<List<Item>> allItems(){
        return ResponseEntity.ok(itemRepo.findAll());
    }
    
}
