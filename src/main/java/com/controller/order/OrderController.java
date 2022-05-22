package com.controller.order;



import java.io.File;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.order.OrderEntity;
import com.entity.response.ResponseEntity;
import com.service.order.OrderService;

@RestController
@CrossOrigin
@RequestMapping(value = "/order")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping("/sendfiles")
	public String addSeller(@Validated @RequestBody OrderEntity oe) {
		System.out.println(oe.getConsumerId()+" "+oe.getSellerId());
		for(File f:oe.getFiles()) {
			System.out.println(f);
		}
		if(oe.getSellerId() == 0) {
			return "Error adding user!";
		}else {
			return "sucess";
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
