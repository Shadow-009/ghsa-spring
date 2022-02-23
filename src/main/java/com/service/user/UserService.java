package com.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.user.UserEntity;
import com.repository.user.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepo;
	
	public UserEntity addUsers(UserEntity user) {
	
		return userRepo.save(user);
	}
	
	public List<UserEntity> getAllUsers(){
		return userRepo.findAll();
	}
	
	public UserEntity getUserById(String id) {
		return userRepo.findById(id).orElse(null);
	}
	
	public void deleteUserBydId(String id) {
		userRepo.deleteById(id);
	}
	
	public UserEntity findByUserEmail(String email) {
		return userRepo.findByUserEmail(email);
	}
	public UserEntity findByUserNumber(String number) {
		return userRepo.findByUserNumber(number);
	}

}
