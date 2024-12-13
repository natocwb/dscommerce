package com.nato.dscommerce.controllers;

import com.nato.dscommerce.dto.ProductDTO;
import com.nato.dscommerce.dto.ProductMinDTO;
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
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService service;
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> FindById(@PathVariable Long id) {
        ProductDTO result = service.findById(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping
    public ResponseEntity<Page<ProductMinDTO>> findAll(@RequestParam(required = false, defaultValue = "") String name, Pageable pageable) {
        Page<ProductMinDTO> result = service.findAll(name,pageable);
        return ResponseEntity.ok(result);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<ProductDTO> insert(@Valid @RequestBody ProductDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);

    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> update(@PathVariable Long id, @Valid @RequestBody ProductDTO dto) {
        dto = service.update(id, dto);
        return ResponseEntity.ok(dto);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
