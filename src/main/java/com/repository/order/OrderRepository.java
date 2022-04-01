package com.repository.order;

import org.springframework.data.jpa.repository.JpaRepository;


import com.entity.order.OrderEntity;


public interface OrderRepository extends JpaRepository<OrderEntity, Integer>{

}
