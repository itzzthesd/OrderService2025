package com.example.orderservice.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.orderservice.dtos.ProductRequestDto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/orders")
public class OrderController {
    
    @PostMapping("/product")
   public ResponseEntity<ProductRequestDto> getOrder(@RequestBody ProductRequestDto productRequestDto){
        String orderServiceResponse = "Success from order service.";
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Accept", "application/json");
        headers.add("auth-token", "heyaccess");
        headers.add("order-service-response", orderServiceResponse);
        ResponseEntity<ProductRequestDto> responseEntity = new ResponseEntity<>(productRequestDto, headers, HttpStatus.OK);

        System.out.println("ORder recieved " + productRequestDto.getName());
        return responseEntity;
    }

    @GetMapping("/category")
   public ResponseEntity<ProductRequestDto> getCategory(@RequestBody ProductRequestDto productRequestDto){
        String orderServiceResponse = "Success from order service.";
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Accept", "application/json");
        headers.add("auth-token", "heyaccess");
        headers.add("order-service-response", orderServiceResponse);
        ResponseEntity<ProductRequestDto> responseEntity = new ResponseEntity<>(productRequestDto, headers, HttpStatus.OK);

        System.out.println("ORder recieved " + productRequestDto.getName());
        return responseEntity;
    }

    @GetMapping("/admin")
    public ResponseEntity<String> adminController(){
        return new ResponseEntity<>("admin api hit", HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<String> userController(){
        return new ResponseEntity<>("user api hit", HttpStatus.OK);
    }

    @GetMapping("/seller")
    public ResponseEntity<String> sellerController(){
        return new ResponseEntity<>("seller api hit", HttpStatus.OK);
    }
    
    @PreAuthorize("hasAuthority('ROLE_admin')")
    @GetMapping("/marketting")
    public ResponseEntity<String> markettingController(){
        return new ResponseEntity<>("marketting api hit", HttpStatus.OK);
    }
}
