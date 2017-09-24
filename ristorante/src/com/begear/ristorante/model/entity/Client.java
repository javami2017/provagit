package com.begear.ristorante.model.entity;

public class Client {

	private int		id;
	private String	name;
	private Table	table;
	private int		presente;

	public Client() {}

	public Client(int id, String name, Table table, int presente) {

		this.id = id;
		this.name = name;
		this.table = table;
		this.presente = presente;
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

	public Table getTable() {

		return table;
	}

	public void setTable(Table table) {

		this.table = table;
	}

	public int getPresente() {

		return presente;
	}

	public void setPresente(int presente) {

		this.presente = presente;
	}

}
