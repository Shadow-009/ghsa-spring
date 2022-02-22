package com.bean.seller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="seller_data")
public class SellerBean {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sellerId;
	
	@NotNull(message = "add your name")
	@Size(min = 2 ,message="name is too short")
	@Column(name="seller_name",nullable = false)
	private String sellerName;
	
	@NotNull(message = "add your number")
	@Size(min = 10,max = 10 ,message = "size must be 10")
	@Pattern(regexp = "[6789]{1}[0-9]{9}",message = "enter valid mobile number!")
	@Column(name="seller_number",nullable = false)
	private String sellerNumber;
	
	@NotNull(message = "add your email")
	@Email(message = "enter valid email")
	@Column(name="seller_email",nullable = false)
	private String sellerEmail;

	@NotNull(message = "add your password")
	@Size(min = 6 ,message = "must be 6 char long")
	@Column(name="seller_password",nullable = false)
	private String sellerPassword;
	
	@NotNull(message = "add your adress")
	@Size(min = 6 ,message = "must be 6 char long")
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
