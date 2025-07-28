package com.vinisnzy.order_reader.controller;

import com.vinisnzy.order_reader.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> createOrder(@RequestPart("file") MultipartFile pdf) {
        service.createOrder(pdf);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
