package com.asm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "`order`")
public class Order {
	
	@Id
	@Column(name="`orderid`", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;
	
	@Column(name="`createddate`", nullable = false)
	private Date createdDate;
	
	@Column(name="`customernumber`", nullable = true)
	private String customerNumber;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}
	
}
