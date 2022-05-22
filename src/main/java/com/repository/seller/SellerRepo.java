package com.repository.seller;

import org.springframework.data.jpa.repository.JpaRepository;


import com.entity.seller.SellerEntity;

public interface SellerRepo extends JpaRepository<SellerEntity, Integer> {
	public SellerEntity findBySellerNumber(String number);
	public SellerEntity findBySellerEmail(String email);
}
