package com.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.user.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String>{

	public UserEntity findByUserEmail(String email);
	public UserEntity findByUserNumber(String number);

}
