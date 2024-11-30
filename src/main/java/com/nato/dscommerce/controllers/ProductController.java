package com.nato.dscommerce.controllers;

import com.nato.dscommerce.ProductRepository;
import com.nato.dscommerce.dto.ProductDTO;
import com.nato.dscommerce.entities.Product;
import com.nato.dscommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService service;
    @GetMapping("/{id}")
    public ProductDTO FindById(@PathVariable Long id) {
        return service.findById(id);
    }
}
