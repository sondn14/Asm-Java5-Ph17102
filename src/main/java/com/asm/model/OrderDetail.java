package com.asm.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "`orderDetail`")
public class OrderDetail implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderDetaiId;
		
	@Column
	private int quantity;
	
	@Column
	private BigDecimal unitPrice;
	
	@ManyToOne
	@JoinColumn(name = "motobikeId")
	private Motobike motobike;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "orderId")
	private Order orders;

	public int getOrderDetaiId() {
		return orderDetaiId;
	}

	public void setOrderDetaiId(int orderDetaiId) {
		this.orderDetaiId = orderDetaiId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Motobike getMotobike() {
		return motobike;
	}

	public void setMotobike(Motobike motobike) {
		this.motobike = motobike;
	}

	public Order getOrder() {
		return orders;
	}

	public void setOrder(Order orders) {
		this.orders = orders;
	}

	public OrderDetail() {
		super();
	}
}
