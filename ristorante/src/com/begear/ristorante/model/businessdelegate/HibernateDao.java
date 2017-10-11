package com.begear.ristorante.model.businessdelegate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.begear.ristorante.model.entity.Client;
import com.begear.ristorante.model.entity.Dish;
import com.begear.ristorante.model.entity.Order;
import com.begear.ristorante.model.entity.Table;
import com.begear.ristorante.model.entity.Waiter;
import com.begear.ristorante.util.HibernateUtil;

public class HibernateDao implements BusinessService {

	@Override
	@SuppressWarnings("unchecked")
	//metodo per ricavare i dati del men� dal database
	public List<Dish> getMenu() {

		List<Dish> list = null;
		Transaction tx = null;
		try (Session s = HibernateUtil.getCurrentSession()) {
			tx = s.beginTransaction();
			list = s.createQuery("FROM Dish").getResultList();
			tx.commit();
		} catch (HibernateException ex) {
			if (tx != null) tx.rollback();
			System.out.println("Errore nella lettura del menu.");
			ex.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Order> getKitchenView() {

		// non nostro
		return null;
	}

	@Override
	//inserisce l'ordine nel database
	public void insertOrder(Order order) {

		Transaction tx = null;
		try (Session s = HibernateUtil.getCurrentSession()) {
			tx = s.beginTransaction();
			s.persist(order);
			tx.commit();
		} catch (HibernateException ex) {
			if (tx != null) tx.rollback();
			System.out.println("Errore nell'inserire l'ordine.");
			ex.printStackTrace();
		}
	}

	@Override
	public void deleteOrder(Order order) {
		// cambio specifiche, non necessario
	}

	@Override
	//inserisce il cliente nel database
	//presente serve per il conto finale e pu� essere o 0 o 1
	public Client insertClient(String name, Table table, int presente) {

		Client client = null;
		Transaction tx = null;
		try (Session s = HibernateUtil.getCurrentSession()) {
			tx = s.beginTransaction();
			client = new Client();
			client.setName(name);
			client.setTable(table);
			client.setPresente(presente);
			s.persist(client);
			tx.commit();
		} catch (HibernateException ex) {
			if (tx != null) tx.rollback();
			System.out.println("Errore nell'inserire il cliente " + name);
			ex.printStackTrace();
		}
		return client;
	}

	@Override
	public List<Order> getWaiterOrderView() {

		// cambio specifiche, non necessario
		return null;
	}

	@Override
	public void payOrder(int orderId) {

		// non nostro cassa
	}

	@Override
	public List<Order> getDeskView() {

		// non nostro cassa
		return null;
	}

	@Override
	public void setReadyOrder(int orderId) {
		// non nostro cucina
	}

	@Override
	//recupera i dati del cameriere attraverso l'id inserito
	public Waiter getWaiterById(int waiterId) {

		Waiter waiter = null;
		Transaction tx = null;
		try (Session s = HibernateUtil.getCurrentSession()) {
			tx = s.beginTransaction();
			waiter = (Waiter) s.get(Waiter.class, waiterId);
			tx.commit();
		} catch (HibernateException ex) {
			if (tx != null) tx.rollback();
			System.out.println("Non � stato possibile recuperare il cameriere con id: " + waiterId);
			ex.printStackTrace();
		}
		return waiter;
	}

	@Override
	@SuppressWarnings("unchecked")
	//recupera il tavolo
	public List<Table> getTables() {

		List<Table> list = null;
		Transaction tx = null;
		try (Session s = HibernateUtil.getCurrentSession()) {
			tx = s.beginTransaction();
			list = s.createQuery("FROM Table").getResultList();
			tx.commit();
		} catch (HibernateException ex) {
			if (tx != null) tx.rollback();
			System.out.println("Errore nel recupero dei tavoli.");
			ex.printStackTrace();
		}
		
		return list;
	}
}
