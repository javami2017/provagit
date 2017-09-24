package com.begear.ristorante.model.entity;

public class Table {

	private int		id;
	private Waiter	waiter;

	public Table() {}

	public Table(int id, Waiter waiter) {

		this.id = id;
		this.waiter = waiter;
	}

	public int getId() {

		return id;
	}

	public void setId(int id) {

		this.id = id;
	}

	public Waiter getWaiter() {

		return waiter;
	}

	public void setWaiter(Waiter waiter) {

		this.waiter = waiter;
	}

}
