package com.riccardofinazzi.hibernate.model.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Owner {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	private String name;

	/*
	 * in db you will see no dog column in owner's table: an owner can have many
	 * dogs, one dog can have one owner. Therefore, dogs will have one column to
	 * store their owner id
	 */
	@OneToMany(mappedBy = "owner")
	private Set<Dog> dogs;

	public Owner() {
	}

	public Owner(int id, String name, Set<Dog> dogs) {
		this.id = id;
		this.name = name;
		this.dogs = dogs;
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

	public Set<Dog> getDogs() {
		return dogs;
	}

	public void setDogs(Set<Dog> dogs) {
		this.dogs = dogs;
	}

}
