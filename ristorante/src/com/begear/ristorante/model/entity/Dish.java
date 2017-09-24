package com.begear.ristorante.model.entity;

import java.math.BigDecimal;

public class Dish {

	private int			id;
	private String		name;
	private BigDecimal	price;
	private String		course;

	public Dish() {}

	public Dish(int id, String name, BigDecimal price, String course) {

		this.id = id;
		this.name = name;
		this.price = price;
		this.course = course;
	}

	public int getId() {

		return id;
	}

	public void setId(int id) {

		this.id = id;
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public java.math.BigDecimal getPrice() {

		return price;
	}

	public void setPrice(BigDecimal price) {

		this.price = price;
	}

	public String getCourse() {

		return course;
	}

	public void setCourse(String course) {

		this.course = course;
	}

}
