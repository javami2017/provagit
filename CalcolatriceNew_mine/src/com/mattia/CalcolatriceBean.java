package com.mattia;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Component;

@Component
@ManagedBean
@SessionScoped
public class CalcolatriceBean {
	private String operazione;
	Double ris = 0.0;
	ArrayList<Cronologia> oper = new ArrayList<Cronologia>();
	Cronologia calc = null;

	// setter e getter
	public String getOperazione() {
		return operazione;
	}

	public void setOperazione(String operazione) {
		this.operazione = operazione;
	}

	public double getRis() {
		return ris;
	}

	public void setRis(double ris) {
		this.ris = ris;
	}

	public ArrayList<Cronologia> getOper() {
		return oper;
	}

	public void setOper(ArrayList<Cronologia> oper) {
		this.oper = oper;
	}

	public Cronologia getCalc() {
		return calc;
	}

	public void setCalc(Cronologia calc) {
		this.calc = calc;
	}

	// metodo per calcolare il risultato
	public String calcola() {
		String[] split = operazione.split("[-+*/^]|(sqrt)|(sin)");
		double val1 = 0;
		double val2 = 0;
		if (split.length > 1 && !(split[0].equals(""))) {
			try {
				val1 = Double.parseDouble(split[0]);
				val2 = Double.parseDouble(split[1]);
			} catch (NumberFormatException e) {
				System.out.println("Stringa scritta male");
				return null;
			}
		} else {
			if (split.length < 1) {
				val1 = Double.parseDouble(split[0]);
				if (operazione.contains("sqrt")) {
					ris = Math.sqrt(val1);
					operazione = "\u221A" + split[0]; // così aggiungo il simbolo della radice quadrata
				}
				addOper(operazione, ris);
				return "calcolatrice";
			}
		}

		// splitto una seconda volta la stringa dell'operazione per poter separare i
		// numeri dai segni
		String[] split2 = operazione.split("[0-9]");
		ArrayList<String> segni = new ArrayList<String>();
		for(String it : split2) {
			if(!it.equals("")) {
				segni.add(it);
			}
		}
		switch (segni.get(0)) {
		case "+":
			ris = val1 + val2;
			break;
		case "-":
			ris = val1 - val2;
			break;
		case "*":
			ris = val1 * val2;
			operazione = split[0] + "\u00D7" + split[1]; // simbolo moltiplicazione
			break;
		case "/":
			ris = val1 / val2;
			operazione = split[0] + "\u00F7" + split[1]; // simbolo divisione
			break;
		case "^":
			ris = Math.pow(val1, val2);
			break;
		case "sin":
			val2 = Double.parseDouble(split[1]);
			ris = Math.sin(Math.toRadians(val2));
			operazione = "sin " + split[1];
			break;
		default:
			System.out.println("Stringa scritta male");
		}
		addOper(operazione, ris);
		return "calcolatrice";
	}

	// metodo per aggiungere un'operazione alla cronologia
	public void addOper(String operaz, Double risult) {
		Cronologia cron = new Cronologia(operaz, risult);
		oper.add(cron);
	}

	// metodo per togliere un'operazione dalla cronologia
	public String deleteOper(Cronologia calc) {
		oper.remove(calc);
		return null;
	}

}
