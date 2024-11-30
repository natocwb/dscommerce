package com.nato.dscommerce.services;

import com.nato.dscommerce.repositories.ProductRepository;
import com.nato.dscommerce.dto.ProductDTO;
import com.nato.dscommerce.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable) {
        Page<Product> result = repository.findAll(pageable);
        return result.map(p -> new ProductDTO(p));
    }

}
