package com.entity.seller;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="seller_data")
public class SellerEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sellerId;
	
	@Column(name="seller_name",nullable = false)
	private String sellerName;
	
	@Column(name="seller_number",nullable = false)
	private String sellerNumber;
	
	@Column(name="seller_email",nullable = false)
	private String sellerEmail;

	@Column(name="seller_password",nullable = false)
	private String sellerPassword;
	
	@Column(name="seller_adress",nullable = false)
	private String sellerAdress;

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getSellerNumber() {
		return sellerNumber;
	}

	public void setSellerNumber(String sellerNumber) {
		this.sellerNumber = sellerNumber;
	}

	public String getSellerEmail() {
		return sellerEmail;
	}

	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}

	public String getSellerPassword() {
		return sellerPassword;
	}

	public void setSellerPassword(String sellerPassword) {
		this.sellerPassword = sellerPassword;
	}

	public String getSellerAdress() {
		return sellerAdress;
	}

	public void setSellerAdress(String sellerAdress) {
		this.sellerAdress = sellerAdress;
	}
	
	
}
