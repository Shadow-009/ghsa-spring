package com.repository.seller;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bean.seller.SellerBean;

public interface SellerRepo extends JpaRepository<SellerBean, Integer> {

}
