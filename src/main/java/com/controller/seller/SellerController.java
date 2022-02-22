package com.controller.seller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.bean.seller.SellerBean;
import com.service.seller.SellerService;

@Controller
public class SellerController {
	
	@Autowired
	SellerService sellerService;
	
	@PostMapping("/addSeller")
	public String addSeller(@Validated @RequestBody SellerBean seller) {
		sellerService.addSeller(seller);
		return "added sucessfully";
	}
	
	@GetMapping("/sellerList")
	public List<SellerBean> getListOfSellers(){
		return sellerService.getSellers();
	}
	@GetMapping("/seller/{id}")
	public SellerBean getPerson(@PathVariable int id){
		return sellerService.getSellerById(id);
	}
	
	@PutMapping("/updateSeller")
	public SellerBean updatePerson(@Validated SellerBean seller) {
		return sellerService.updateSeller(seller);
	}
	
	@DeleteMapping("/deleteContact/{id}")
	public String delete(@PathVariable int id) {
		return sellerService.deleteSeller(id);
	}
}
