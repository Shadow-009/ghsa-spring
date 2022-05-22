package com.controller.seller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.response.ResponseEntity;
import com.entity.seller.SellerEntity;
import com.service.seller.SellerService;

@CrossOrigin
@RestController
public class SellerController {
	
	@Autowired
	SellerService sellerService;
	
	@PostMapping("/addseller")
	public ResponseEntity addSeller(@RequestBody SellerEntity seller) {
		SellerEntity sellerEntity = sellerService.addSeller(seller);
		if(sellerEntity==null) {
			return new ResponseEntity(-1,"Error adding user!",null);
		}else {
			return new ResponseEntity(200, "User added successfully!", sellerEntity);
		}
	}
	
	@GetMapping("/sellerlist")
	public List<SellerEntity> getListOfSellers(){
		return sellerService.getSellers();
	}
	@GetMapping("/seller/{id}")
	public SellerEntity getSeller(@PathVariable int id){
		return sellerService.getSellerById(id);
	}
	
	@PutMapping("/updateseller")
	public SellerEntity updatePerson(@Validated SellerEntity seller) {
		return sellerService.updateSeller(seller);
	}
	
	@DeleteMapping("/deletecontact/{id}")
	public String delete(@PathVariable int id) {
		return sellerService.deleteSeller(id);
	}
}
