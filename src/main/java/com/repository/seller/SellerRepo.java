package com.repository.seller;

import org.springframework.data.jpa.repository.JpaRepository;


import com.entity.seller.SellerEntity;

public interface SellerRepo extends JpaRepository<SellerEntity, Integer> {

}
