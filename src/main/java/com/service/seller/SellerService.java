package com.service.seller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.seller.SellerBean;
import com.repository.seller.SellerRepo;

@Service
public class SellerService {
	
	@Autowired
	SellerRepo sellerRepo;
	
	public SellerBean addSeller(SellerBean sb) {
		return sellerRepo.save(sb);
	}
	
	public SellerBean getSellerById(int id) {
		return sellerRepo.findById(id).orElse(null);
	}
	
	public List<SellerBean> getSellers() {
		return sellerRepo.findAll();
	}
	
	public  SellerBean updateSeller(SellerBean sb) {
		SellerBean newSeller = getSellerById(sb.getSellerId());
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

}
