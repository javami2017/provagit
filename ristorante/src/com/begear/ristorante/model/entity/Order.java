package com.begear.ristorante.model.entity;

import java.util.Date;

public class Order {

	private int		id;
	private Dish	dish;
	private Client	client;
	private int		payed;
	private int		ready;
	private Date	date;

	public Order() {}

	public Order(Dish dish, Client client, int payed, int ready, Date date) {

		this.dish = dish;
		this.client = client;
		this.payed = payed;
		this.ready = ready;
		this.date = date;
	}

	public int getId() {

		return id;
	}

	public void setId(int id) {

		this.id = id;
	}

	public Dish getDish() {

		return dish;
	}

	public void setDish(Dish dish) {

		this.dish = dish;
	}

	public Client getClient() {

		return client;
	}

	public void setClient(Client client) {

		this.client = client;
	}

	public int getPayed() {

		return payed;
	}

	public void setPayed(int payed) {

		this.payed = payed;
	}

	public int getReady() {

		return ready;
	}

	public void setReady(int ready) {

		this.ready = ready;
	}

	public Date getDate() {

		return date;
	}

	public void setDate(Date date) {

		this.date = date;
	}

}
