package com.nato.dscommerce.services;

import com.nato.dscommerce.dto.OrderDTO;
import com.nato.dscommerce.dto.ProductDTO;
import com.nato.dscommerce.entities.Order;
import com.nato.dscommerce.entities.Product;
import com.nato.dscommerce.repositories.OrderRepository;
import com.nato.dscommerce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;
    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {
        Order order = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Order not found"));
        OrderDTO dto = new OrderDTO(order);
        return dto;
    }
    }
