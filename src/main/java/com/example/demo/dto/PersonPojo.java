package com.example.demo.dto;

import com.example.demo.entity.Ingredient;
import lombok.Data;

import java.util.UUID;

@Data
public class PersonPojo {
    private Long id;
    private String name;
    private String description;
}
