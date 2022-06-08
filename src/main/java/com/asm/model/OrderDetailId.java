package com.asm.model;

import java.io.Serializable;

public class OrderDetailId implements Serializable {

	private static final long serialVersionUID = 1L;

	private Order order;
	private Motobike motobike;

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public OrderDetailId() {
		super();
	}

}
