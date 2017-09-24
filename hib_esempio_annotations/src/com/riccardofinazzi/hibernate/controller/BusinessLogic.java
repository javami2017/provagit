package com.riccardofinazzi.hibernate.controller;

import org.hibernate.Session;

import com.riccardofinazzi.hibernate.model.entity.Dog;
import com.riccardofinazzi.hibernate.model.entity.Owner;
import com.riccardofinazzi.hibernate.util.HibernateUtil;
import com.riccardofinazzi.hibernate.util.SysinReader;

public class BusinessLogic {

	public static void main(String[] args) throws InterruptedException {

		// Recupero la sessione: attenzione, questa operazione
		// può essere gestita come un Singleton lungo tutta l’applicazione
		Session session = HibernateUtil.getCurrentSession();

		// Creo una nuova persona
		Owner o = new Owner();
		Dog d = new Dog();
		d.setName("Fido");

		o.setName("Proprietario");

		d.setOwner(o);
		// Utilizziamo un modello transazionale dichiarativo
		session.beginTransaction();

		// Chiedo al middleware di salvare questo oggetto nel database
		session.save(o);
		//session.save(d); /* Objects must be saved or they won't be persisted */

		// fine della transazione: salviamo tramite commit()
		session.getTransaction().commit();

		SysinReader sr = new SysinReader();
		while (!sr.readString("Press enter 'x' to exit").equals("x"))
			Thread.sleep(50);

		session.close();

		HibernateUtil.closeFactory();

	}
}
