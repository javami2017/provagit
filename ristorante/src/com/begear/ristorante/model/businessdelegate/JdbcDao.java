package com.begear.ristorante.model.businessdelegate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.begear.ristorante.model.entity.Client;
import com.begear.ristorante.model.entity.Dish;
import com.begear.ristorante.model.entity.Order;
import com.begear.ristorante.model.entity.Table;
import com.begear.ristorante.model.entity.Waiter;

import com.begear.ristorante.util.JdbcUtil;

public class JdbcDao implements BusinessService {

	private Connection connection;

	public JdbcDao() {

		connection = JdbcUtil.getConnection("jdbc:mysql://localhost:3306/ristorante?useSSL=false","root","root");
	}

	@Override
	public List<Dish> getMenu() {

		String query = "SELECT * FROM piatto;";
		List<Dish> result = new ArrayList<Dish>();
		Dish d = null;
		try {
			Statement s = connection.createStatement();
			ResultSet rs = s.executeQuery(query);
			while (rs.next()) {
				d = new Dish(rs.getInt(1), rs.getString(2), new java.math.BigDecimal(rs.getDouble(3)), rs.getString(4));
				result.add(d);
			}
			return result;
		} catch (SQLException e) {
			System.out.println("Errore nella lettura del menu.");
		}
		return null;
	}

	@Override
	public List<Order> getKitchenView() {

		// non nostro
		return null;
	}

	@Override
	public void insertOrder(Order order) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentTime = sdf.format(order.getDate());

		String query = "INSERT INTO ordine (x_idpiatto, x_idcliente, pagato, ready, dataOrdine) VALUES (?, ?, ?, ?, ?);";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, order.getDish().getId());
			ps.setInt(2, order.getClient().getId());
			ps.setInt(3, 0);
			ps.setInt(4, 0);
			ps.setString(5, currentTime);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Errore nell'inserire l'ordine.");
			e.printStackTrace();
		}
	}

	@Override
	public void deleteOrder(Order order) {
		// cambio specifiche, non necessario
	}

	@Override
	public Client insertClient(String name, Table table, int presente) {

		String insert = "INSERT INTO cliente (nome, x_idtavolo, presente) VALUES ('"	+ name + "', " + table.getId()
						+ ", " + presente + ");";
		String recover = "SELECT * FROM cliente WHERE nome = '"	+ name + "' AND x_idtavolo = " + table.getId()
							+ " AND presente = " + presente + ";";
		Client client = null;

		try {

			Statement st = connection.createStatement();
			st.executeUpdate(insert);

			Statement st2 = connection.createStatement();
			ResultSet rs = st2.executeQuery(recover);
			if (rs.next()) client = new Client(rs.getInt(1), name, table, presente);

		} catch (SQLException e) {
			System.out.println("Errore nell'inserire il cliente " + name);
			e.printStackTrace();
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
		String query = "SELECT * FROM cameriere WHERE idcameriere = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, waiterId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) waiter = new Waiter(rs.getInt(1), rs.getString(2));
		} catch (SQLException e) {
			System.out.println("Non è stato possibile recuperare il cameriere con id: " + waiterId);
		}
		return waiter;
	}

	@Override
	public List<Table> getTables() {

		String query = "SELECT * FROM tavolo;";
		List<Table> result = new ArrayList<Table>();
		Table t = null;
		try {
			Statement s = connection.createStatement();
			ResultSet rs = s.executeQuery(query);
			while (rs.next()) {
				t = new Table(rs.getInt(1), getWaiterById(rs.getInt(2)));
				result.add(t);
			}
		} catch (SQLException e) {
			System.out.println("Errore nella lettura del menu.");
			return null;
		}
		return result;
	}

}
