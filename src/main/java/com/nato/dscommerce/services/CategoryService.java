package com.nato.dscommerce.services;

import com.nato.dscommerce.dto.CategoryDTO;
import com.nato.dscommerce.dto.ProductDTO;
import com.nato.dscommerce.dto.ProductMinDTO;
import com.nato.dscommerce.entities.Category;
import com.nato.dscommerce.entities.Product;
import com.nato.dscommerce.repositories.CategoryRepository;
import com.nato.dscommerce.repositories.ProductRepository;
import com.nato.dscommerce.services.exceptions.DatabaseException;
import com.nato.dscommerce.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;



    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll() {
        List<Category> result = repository.findAll();
        return result.stream().map(x -> new CategoryDTO(x)).toList();
    }

}
