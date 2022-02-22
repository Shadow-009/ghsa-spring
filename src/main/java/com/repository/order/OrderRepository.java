package com.repository.order;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bean.order.OrderBean;

public interface OrderRepository extends JpaRepository<OrderBean, Integer>{

}
