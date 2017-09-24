package com.begear.ristorante.model.businessdelegate;

import java.util.List;

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
	public List<Dish> getMenu() {

		List<Dish> list = null;
		try (Session s = HibernateUtil.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			list = s.createQuery("FROM Dish").getResultList();
			tx.commit();
		}
		return list;
	}

	@Override
	public List<Order> getKitchenView() {

		// non nostro
		return null;
	}

	@Override
	public void insertOrder(Order order) {

		try (Session s = HibernateUtil.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.persist(order);
			tx.commit();
		}
	}

	@Override
	public void deleteOrder(Order order) {
		// cambio specifiche, non necessario
	}

	@Override
	public Client insertClient(String name, Table table, int presente) {

		Client client = null;
		try (Session s = HibernateUtil.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			client = new Client();
			client.setName(name);
			client.setTable(table);
			client.setPresente(presente);
			s.persist(client);
			tx.commit();
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
	public Waiter getWaiterById(int waiterId) {

		Waiter waiter = null;
		try (Session s = HibernateUtil.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			waiter = (Waiter) s.get(Waiter.class, waiterId);
			tx.commit();
		}
		return waiter;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Table> getTables() {

		List<Table> list = null;
		try (Session s = HibernateUtil.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			list = s.createQuery("FROM Table").getResultList();
			tx.commit();
		}
		return list;
	}
}
