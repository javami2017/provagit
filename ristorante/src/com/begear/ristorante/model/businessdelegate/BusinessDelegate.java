package com.begear.ristorante.model.businessdelegate;

import java.util.List;

import com.begear.ristorante.model.entity.Client;
import com.begear.ristorante.model.entity.Dish;
import com.begear.ristorante.model.entity.Order;
import com.begear.ristorante.model.entity.Table;
import com.begear.ristorante.model.entity.Waiter;

public class BusinessDelegate {

	private BusinessLookUp lookupService = new BusinessLookUp();

	private BusinessService	businessService;
	private ServiceType		serviceType;

	public void setServiceType(ServiceType serviceType) {

		this.serviceType = serviceType;
	}

	public List<Dish> getMenu() {

		businessService = lookupService.getBusinessService(serviceType);
		return businessService.getMenu();
	}

	public List<Order> getKitchenView() {

		// non nostro
		return null;
	}

	public void insertOrder(Order order) {

		businessService = lookupService.getBusinessService(serviceType);
		businessService.insertOrder(order);
	}

	public void deleteOrder(Order order) {
		// cambio specifiche, non necessario
	}

	public Client insertClient(String name, Table table, int presente) {

		businessService = lookupService.getBusinessService(serviceType);
		return businessService.insertClient(name, table, presente);
	}

	public List<Order> getWaiterOrderView() {

		// non nostro
		return null;
	}

	public void payOrder(int orderId) {

		businessService = lookupService.getBusinessService(serviceType);
		businessService.payOrder(orderId);
	}

	public List<Order> getDeskView() {

		// non nostro
		return null;
	}

	public void setReadyOrder(int orderId) {

		businessService = lookupService.getBusinessService(serviceType);
		businessService.setReadyOrder(orderId);
	}

	public Waiter getWaiterById(int waiterId) {

		businessService = lookupService.getBusinessService(serviceType);
		return businessService.getWaiterById(waiterId);
	}

	public List<Table> getTables() {

		businessService = lookupService.getBusinessService(serviceType);
		return businessService.getTables();
	}

}
