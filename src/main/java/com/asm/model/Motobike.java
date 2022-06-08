package com.asm.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Nationalized;

@Entity
@Table(name="`motobikes`")
public class Motobike {
	
	@Id
	@Column(name = "`motobikeid`")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer motobikeId;
	
	@Column
	@Nationalized
	private String motobikeName;
	
	@Column
	private Date createdate;
	
	@Column
	private BigDecimal price;
	
	@Column
	private Integer quantity;
	
	@Column
	private MotobikeType motobikeType;
	
	@Column
	private MotobikeColor motobikeColor;
	
	@Column
	private MotobikeCompany motobikeCompany;

	@Column
	private String anh;

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

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public MotobikeType getMotobikeType() {
		return motobikeType;
	}

	public void setMotobikeType(MotobikeType motobikeType) {
		this.motobikeType = motobikeType;
	}

	public MotobikeColor getMotobikeColor() {
		return motobikeColor;
	}

	public void setMotobikeColor(MotobikeColor motobikeColor) {
		this.motobikeColor = motobikeColor;
	}

	public MotobikeCompany getMotobikeCompany() {
		return motobikeCompany;
	}

	public void setMotobikeCompany(MotobikeCompany motobikeCompany) {
		this.motobikeCompany = motobikeCompany;
	}

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	public Motobike() {
		super();
	}
	
}
