package com.service.order;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.order.OrderEntity;
import com.repository.order.OrderRepository;
@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepo;
	
	public OrderEntity addOrder(OrderEntity sb) {
		return orderRepo.save(sb);
	}
	
	public OrderEntity getOrderById(int id) {
		return orderRepo.findById(id).orElse(null);
	}
	
	public List<OrderEntity> getOrders() {
		return orderRepo.findAll();
	}
	/*
	 * public OrderEntity updateOrder(OrderEntity sb) { OrderEntity newOrder =
	 * getOrderById(sb.getOrderId()); newOrder.setDate(sb.getDate());
	 * newOrder.setConsumerId(sb.getConsumerId());
	 * newOrder.setSellerId(sb.getSellerId());
	 * newOrder.setOrderPrice(sb.getOrderPrice());
	 * 
	 * 
	 * return orderRepo.save(newOrder); }
	 */

	public String deleteOrder(int id) {
		orderRepo.deleteById(id);
		return "Order's Account Deleted...";
	}

}
