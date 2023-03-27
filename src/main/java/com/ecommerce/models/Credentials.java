package com.ecommerce.models;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Component
@AllArgsConstructor
public class Credentials {
    private String email;
    private String password;
}
