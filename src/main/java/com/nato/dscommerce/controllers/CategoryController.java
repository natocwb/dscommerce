package com.nato.dscommerce.controllers;

import com.nato.dscommerce.dto.CategoryDTO;
import com.nato.dscommerce.dto.ProductDTO;
import com.nato.dscommerce.dto.ProductMinDTO;
import com.nato.dscommerce.services.CategoryService;
import com.nato.dscommerce.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService service;
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll() {
        List<CategoryDTO> result = service.findAll();
        return ResponseEntity.ok(result);
    }
}
