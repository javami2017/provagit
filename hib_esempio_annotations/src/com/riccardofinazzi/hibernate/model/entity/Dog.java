package com.riccardofinazzi.hibernate.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity /* @Table(name="") /* No need as the class name and db table have a
		 * matching name */
public class Dog {

	@Id /* use this notation for the primary ID */
	@GeneratedValue(strategy = GenerationType.IDENTITY) /* IDENTITY means
														 * AUTOINCREMENT */
	private int id;

	@Column /* @Column(name="") /* No need as field's name and db column have a
			 * matching name */
	private String name;

	@ManyToOne /* An owner can have many dogs */
	/* The connecting (join) table that will hold the owner's id and the foreign
	 * key name */
	@JoinColumn(name = "owner_id", foreignKey = @ForeignKey(name = "fk_dog__owner_id__owner_id"))
	private Owner owner;

	public Dog() {}

	public Dog(int id, String name, Owner owner) {

		this.id = id;
		this.name = name;
		this.owner = owner;
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

	public Owner getOwner() {

		return owner;
	}

	public void setOwner(Owner owner) {

		this.owner = owner;
	}

}
