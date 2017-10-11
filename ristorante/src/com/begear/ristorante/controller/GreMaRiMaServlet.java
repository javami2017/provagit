package com.begear.ristorante.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.begear.ristorante.model.businessdelegate.BusinessDelegate;
import com.begear.ristorante.model.businessdelegate.ServiceType;
import com.begear.ristorante.model.entity.Client;
import com.begear.ristorante.model.entity.Dish;
import com.begear.ristorante.model.entity.Order;
import com.begear.ristorante.model.entity.Table;

@WebServlet("/view/GreMaRiMaServlet")
public class GreMaRiMaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private BusinessDelegate bd 	   = new BusinessDelegate();
	private Map<Integer, Dish> dishes  = new HashMap<Integer, Dish>();
	private Map<Integer, Table> tables = new HashMap<Integer, Table>();
	{ //qua popola le mappe dishes e tables con i piatti e i tavoli gi� inseriti nel database
		bd.setServiceType(ServiceType.HIBERNATE);

		for (Dish dish : bd.getMenu()) {
			dishes.put(dish.getId(), dish);
		}

		for (Table table : bd.getTables()) {
			tables.put(table.getId(), table);
		}
	}
	private Map<Integer, Client> clienti;
	private List<Order> 		 ordini;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String requestPhase, sessionPhase;
		Integer numTavolo, numClienti;

		sessionPhase = (String) req.getSession().getAttribute("sessionPhase");

		switch (sessionPhase) {
		case "1": // selezione tavolo e inserimento clienti

			requestPhase = req.getParameter("requestPhase");

			if (requestPhase != null && requestPhase.equals("1")) {
				// inserisce il numero del tavolo e il numero dei clienti

				numTavolo  = Integer.parseInt(req.getParameter("tavolo"));
				numClienti = Integer.parseInt(req.getParameter("numero"));

				req.getSession().setAttribute("tavoloSelezionato", numTavolo);
				req.getSession().setAttribute("numeroClienti", numClienti);

			} else if (requestPhase != null && requestPhase.equals("2")) {

				// prende il numero del tavolo e dei clienti
				numTavolo  = (Integer) req.getSession().getAttribute("tavoloSelezionato");
				numClienti = (Integer) req.getSession().getAttribute("numeroClienti");

				clienti = new HashMap<Integer, Client>();

				// inserisce nella mappa i vari clienti sotto forma di oggetto Client
				for (int i = 1; i <= numClienti; i++) {
					Client c = bd.insertClient(req.getParameter("cliente_" + i), // client
													  tables.get(numTavolo), 1); // table, presente
					clienti.put(c.getId(), c);
				}

				// se proceedToOrder � true si pu� passare alla visualizzazione del men�
				if (req.getParameter("proceedToOrder").equals("true")) {
					req.getSession().setAttribute("menu", bd.getMenu()); // recupera il men� e lo setta come attributo
																			// "menu"
					req.getSession().setAttribute("sessionPhase", "2"); // setta la sessionPhase a 2 per poter passare
																		// alla vista men�
				}

				req.getSession().setAttribute("clienti", clienti);
			}
			break;
		case "2": // visualizzazione del men�

			req.getSession().setAttribute("menu", bd.getMenu());
			ordini = new ArrayList<Order>();

			String idCliente = req.getParameter("clientId"); //l'idCliente viene recuperato dal parametro "clientId" della pagina JSP
			String idPiatto = null;

			// scorre i vari piatti del men� per inserire quelli selezionati nell'ordine
			for (int i = 1; i <= dishes.size(); i++) {
				if ((idPiatto = req.getParameter("cb_" + i)) != null) {
					Order o = new Order(dishes.get(Integer.parseInt(idPiatto)), 	  //dish
											clienti.get(Integer.parseInt(idCliente)), //client
												0, 0, new Date());					  //payed, ready, Date
					ordini.add(o);
					bd.insertOrder(o);
				}
			}

			req.getSession().setAttribute("clienteSelezionato", idCliente);
			req.getSession().setAttribute("sessionPhase", "3");
			//adesso sessionPhase="3" => fine parte inserimento ordini
			break;
		}

		RequestDispatcher view = req.getRequestDispatcher("paginaunica.jsp");
		view.forward(req, resp);

	}
}
