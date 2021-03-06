package com.controller.session;

import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.response.ResponseEntity;
import com.entity.seller.SellerEntity;
import com.entity.user.UserEntity;

import com.service.seller.SellerService;



import com.repository.user.UserRepository;


import com.service.user.UserService;

@CrossOrigin 
@RestController
public class LoginController {

	@Autowired
	private UserService userService;
	@Autowired
	private SellerService sellerService;
	
	@PostMapping("/signup")
	public ResponseEntity registerData(@RequestBody UserEntity user) {
		
		UserEntity userEntity = userService.addUsers(user);
		
		if(userEntity==null) {
			return new ResponseEntity(-1,"Error adding user!",null);
		}else {
			return new ResponseEntity(200, "User added successfully!", userEntity);
		}
		
	}
	
	
	@GetMapping("/login")
	public ResponseEntity login(@RequestParam("data") String data,@RequestParam("password") String password) throws NullPointerException{
		
		System.err.println("data="+data);
		System.err.println("password="+password);
		
		if(data.length()==10) {
			
			UserEntity user= userService.findByUserNumber(data);
			
			if(user==null) {
				SellerEntity seller = sellerService.findBySellerNumber(data);
				if(seller == null)
					return new ResponseEntity(-1, "no user found with this number", null);
				
				else {
					if(seller.getSellerPassword().equals(password)){
						return new ResponseEntity(200, "seller details retrived successfully!", seller);
					}
					else {
						return new ResponseEntity(-1,"invalid credentails!", null);
					}
				}
			}
		    else {
				
				if(user.getUserPassword().equals(password)) {
					return new ResponseEntity(200, "user details retrived successfully!", user);
				}else {
					return new ResponseEntity(-1,"invalid credentails!", null);
				}

			}
		}
		else{
			UserEntity user= userService.findByUserEmail(data);
			
			if(user==null) {
				SellerEntity seller = sellerService.findBySellerEmail(data);
				if(seller == null)
					return new ResponseEntity(-1, "no user found with this number", null);
				
				else {
					if(seller.getSellerPassword().equals(password)){
						return new ResponseEntity(200, "seller details retrived successfully!",seller);
					}
					else {
						return new ResponseEntity(-1,"invalid credentails!", null);
					}
				}
								
			}else {
				
				if(user.getUserPassword().equals(password)) {
					
					return new ResponseEntity(200, "user details retrived successfully!", user);
				}else {
					return new ResponseEntity(-1,"invalid credentails!", null);
				}
	
			}
		}
	}
	
}
