package com.begear.ristorante.model.businessdelegate;

import java.util.List;

import com.begear.ristorante.model.entity.Client;
import com.begear.ristorante.model.entity.Dish;
import com.begear.ristorante.model.entity.Order;
import com.begear.ristorante.model.entity.Table;
import com.begear.ristorante.model.entity.Waiter;

public interface BusinessService {

	//@formatter:off
	public List<Dish> getMenu();
	public List<Order> getKitchenView();
	public void insertOrder(Order order);
	public void deleteOrder(Order order);
	public Client insertClient(String name, Table table, int presente);
	public List<Order> getWaiterOrderView();
	public void payOrder(int orderId);
	public List<Order> getDeskView();
	public void setReadyOrder(int orderId);
	public Waiter getWaiterById(int waiterId);
	public List<Table> getTables();
}
