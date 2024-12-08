package com.nato.dscommerce.repositories;

import com.nato.dscommerce.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE upper(p.name) LIKE upper(CONCAT('%', :name, '%'))")
    Page<Product> searchByName(String name, Pageable pageable);
}
