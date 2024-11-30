package com.nato.dscommerce.services;

import com.nato.dscommerce.ProductRepository;
import com.nato.dscommerce.dto.ProductDTO;
import com.nato.dscommerce.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        Optional<Product> product = repository.findById(id);
        ProductDTO dto = new ProductDTO(product.get());
        return dto;
    }
}
