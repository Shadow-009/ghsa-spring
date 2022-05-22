package com.service.seller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.seller.SellerEntity;
import com.repository.seller.SellerRepo;

@Service
public class SellerService {
	
	@Autowired
	SellerRepo sellerRepo;
	
	public SellerEntity addSeller(SellerEntity sb) {
		return sellerRepo.save(sb);
	}
	
	public SellerEntity getSellerById(int id) {
		return sellerRepo.findById(id).orElse(null);
	}
	
	public List<SellerEntity> getSellers() {
		return sellerRepo.findAll();
	}
	
	public  SellerEntity updateSeller(SellerEntity sb) {
		SellerEntity newSeller = getSellerById(sb.getSellerId());
		newSeller.setSellerName(sb.getSellerName());
		newSeller.setSellerEmail(sb.getSellerEmail());
		newSeller.setSellerNumber(sb.getSellerNumber());
		newSeller.setSellerAdress(sb.getSellerAdress());
		newSeller.setSellerPassword(sb.getSellerPassword());
		
		return sellerRepo.save(newSeller);
	}

	public String deleteSeller(int id) {
		sellerRepo.deleteById(id);
		return "Seller's Account Deleted...";
	}
	
	public SellerEntity findBySellerEmail(String email) {
		return sellerRepo.findBySellerEmail(email);
	}
	public SellerEntity findBySellerNumber(String number) {
		return sellerRepo.findBySellerNumber(number);
	}
}
