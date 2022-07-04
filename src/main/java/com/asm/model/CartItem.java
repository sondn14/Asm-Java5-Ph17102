package com.asm.model;

import java.math.BigDecimal;

public class CartItem {
	private Motobike motobike;
	private Integer motobikeId;
	private String motobikeName;
	private int quantity;
	private BigDecimal price;
	private String anh;
	public Motobike getMotobike() {
		return motobike;
	}
	public void setMotobike(Motobike motobike) {
		this.motobike = motobike;
	}
	public Integer getMotobikeId() {
		return motobikeId;
	}
	public void setMotobikeId(Integer motobikeId) {
		this.motobikeId = motobikeId;
	}
	public String getMotobikeName() {
		return motobikeName;
	}
	public void setMotobikeName(String motobikeName) {
		this.motobikeName = motobikeName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public CartItem() {
		super();
	}
}
