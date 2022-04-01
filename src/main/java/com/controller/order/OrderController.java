package com.controller.order;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.entity.order.OrderEntity;
import com.entity.response.ResponseEntity;
import com.service.order.OrderService;

@Controller
@CrossOrigin
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping("/sendfiles")
	public ResponseEntity addSeller(@Validated @RequestBody OrderEntity order) {
		OrderEntity orderEntity = orderService.addOrder(order);
		if(orderEntity==null) {
			return new ResponseEntity(-1,"Error adding user!",null);
		}else {
			return new ResponseEntity(200, "User added successfully!", orderEntity);
		}
	}
	
	@GetMapping("/orderlist")
	public List<OrderEntity> getListOfSellers(){
		return orderService.getOrders();
	}
	
	@DeleteMapping("/deleteorder/{id}")
	public String delete(@PathVariable int id) {
		return orderService.deleteOrder(id);
	}
}
