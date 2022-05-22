package com.entity.order;

import java.io.File;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "order_data")
public class OrderEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	// private int orderId;
	// private Date date;
	// private double orderPrice;
	private int consumerId;
	private int sellerId;
	private ArrayList<File> files;

	/*
	 * public int getOrderId() { return orderId; } public void setOrderId(int
	 * orderId) { this.orderId = orderId; } public Date getDate() { return date; }
	 * public void setDate(Date date) { this.date = date; } public double
	 * getOrderPrice() { return orderPrice; } public void setOrderPrice(double
	 * orderPrice) { this.orderPrice = orderPrice; }
	 */
	public int getConsumerId() {
		return consumerId;
	}

	public void setConsumerId(int consumerId) {
		this.consumerId = consumerId;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	public ArrayList<File> getFiles() { return files; } 
	public void setFiles(ArrayList<File> files) { this.files = files; }
	  
	

}
