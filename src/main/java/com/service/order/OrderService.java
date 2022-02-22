package com.service.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.order.OrderBean;
import com.repository.order.OrderRepository;
@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepo;
	
	public OrderBean addOrder(OrderBean sb) {
		return orderRepo.save(sb);
	}
	
	public OrderBean getOrderById(int id) {
		return orderRepo.findById(id).orElse(null);
	}
	
	public List<OrderBean> getOrders() {
		return orderRepo.findAll();
	}
	
	public  OrderBean updateOrder(OrderBean sb) {
		OrderBean newOrder = getOrderById(sb.getOrderId());
		newOrder.setDate(sb.getDate());
		newOrder.setConsumerId(sb.getConsumerId());
		newOrder.setSellerId(sb.getSellerId());
		newOrder.setOrderPrice(sb.getOrderPrice());
		
		
		return orderRepo.save(newOrder);
	}

	/*public String deleteOrder(int id) {
		orderRepo.deleteById(id);
		return "Order's Account Deleted...";
	}*/

}
