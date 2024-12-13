package com.nato.dscommerce.repositories;

import com.nato.dscommerce.entities.Order;
import com.nato.dscommerce.entities.OrderItem;
import com.nato.dscommerce.entities.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {


}
