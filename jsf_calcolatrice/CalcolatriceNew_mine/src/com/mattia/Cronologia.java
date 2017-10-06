package com.mattia;

public class Cronologia {
	private String oper;
	private Double risultato;

	public Cronologia(String oper, Double risultato) {
		this.oper = oper;
		this.risultato = risultato;
	}

	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}

	public Double getRisultato() {
		return risultato;
	}

	public void setRisultato(Double risultato) {
		this.risultato = risultato;
	}

}
