package com.nato.dscommerce.services;

import com.nato.dscommerce.dto.OrderDTO;
import com.nato.dscommerce.dto.OrderItemDTO;
import com.nato.dscommerce.dto.ProductDTO;
import com.nato.dscommerce.entities.*;
import com.nato.dscommerce.repositories.OrderItemRepository;
import com.nato.dscommerce.repositories.OrderRepository;
import com.nato.dscommerce.repositories.ProductRepository;
import com.nato.dscommerce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {
        Order order = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Order not found"));
        OrderDTO dto = new OrderDTO(order);
        return dto;
    }

    @Transactional
    public OrderDTO insert(OrderDTO dto) {
        Order order = new Order();
        order.setMoment(Instant.now());
        order.setStatus(OrderStatus.WAITING_PAYMENT);
        User user = userService.authenticate();
        order.setClient(user);
        
        for (OrderItemDTO p : dto.getItems()) {
            Product product = productRepository.getReferenceById(p.getProductId());
            OrderItem orderItem = new OrderItem(order, product, p.getQuantity(),product.getPrice());
            order.getItems().add(orderItem);
        }
        order = repository.save(order);
        orderItemRepository.saveAll(order.getItems());
        return new OrderDTO(order);
    }


}
