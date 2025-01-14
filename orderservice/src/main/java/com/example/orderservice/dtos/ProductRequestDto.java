package com.example.orderservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDto {
    private String name;
    private double price;
}

