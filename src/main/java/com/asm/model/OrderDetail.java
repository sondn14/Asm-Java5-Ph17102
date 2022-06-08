package com.asm.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "`orderdetail`")
@IdClass(OrderDetailId.class)
public class OrderDetail {

	@Id
	@ManyToOne
	@JoinColumn(name = "`orderid`", insertable = false, updatable = false)
	private Order order;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "`motobikeid`", insertable = false, updatable = false)
	private Motobike motobike;
	
	@Column(name="`purchasedquantity`", nullable = false)
	private Integer purchasedQuantity;
	
	@Column(name="`purchasedmoney`", nullable = false)
	private BigDecimal purchasedMoney;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Motobike getMotobike() {
		return motobike;
	}

	public void setMotobike(Motobike motobike) {
		this.motobike = motobike;
	}

	public Integer getPurchasedQuantity() {
		return purchasedQuantity;
	}

	public void setPurchasedQuantity(Integer purchasedQuantity) {
		this.purchasedQuantity = purchasedQuantity;
	}

	public BigDecimal getPurchasedMoney() {
		return purchasedMoney;
	}

	public void setPurchasedMoney(BigDecimal purchasedMoney) {
		this.purchasedMoney = purchasedMoney;
	}

	public OrderDetail() {
		super();
	}

	
	
	
}
