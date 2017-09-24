package com.begear.ristorante.model.entity;

public class Waiter {

	private int		id;
	private String	name;

	public Waiter() {}

	public Waiter(int id, String name) {

		this.id = id;
		this.name = name;
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

}
