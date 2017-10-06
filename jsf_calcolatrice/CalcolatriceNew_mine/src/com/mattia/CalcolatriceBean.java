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
		String[] split = operazione.split("[-+*/^]|(sqrt)");
		double val1 = 0;
		double val2 = 0;
		if (split.length > 1) {
			try {
				val1 = Double.parseDouble(split[0]);
				val2 = Double.parseDouble(split[1]);
			} catch (NumberFormatException e) {
				System.out.println("Stringa scritta male");
				return null;
			}
		} else {
			val1 = Double.parseDouble(split[0]);
			if (operazione.contains("sqrt"))
				ris = Math.sqrt(val1);
			operazione = "\u221A" + split[0];
			addOper(operazione, ris);
			return "calcolatrice";
		}

		if (operazione.contains("+"))
			ris = val1 + val2;
		else if (operazione.contains("-"))
			ris = val1 - val2;
		else if (operazione.contains("*"))
			ris = val1 * val2;
		else if (operazione.contains("/"))
			ris = val1 / val2;
		else if (operazione.contains("^"))
			ris = Math.pow(val1, val2);
		else {
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
