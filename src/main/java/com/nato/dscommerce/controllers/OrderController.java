package com.nato.dscommerce.controllers;

import com.nato.dscommerce.dto.OrderDTO;
import com.nato.dscommerce.dto.ProductDTO;
import com.nato.dscommerce.entities.Order;
import com.nato.dscommerce.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService service;

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> FindById(@PathVariable Long id) {
        OrderDTO result = service.findById(id);
        return ResponseEntity.ok(result);
    }
}
