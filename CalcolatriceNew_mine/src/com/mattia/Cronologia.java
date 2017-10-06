package com.mattia;

public class Cronologia {
	private String operaz;
	private Double risultato;

	public Cronologia(String operaz, Double risultato) {
		this.operaz = operaz;
		this.risultato = risultato;
	}

	public String getOperaz() {
		return operaz;
	}

	public void setOper(String operaz) {
		this.operaz = operaz;
	}

	public Double getRisultato() {
		return risultato;
	}

	public void setRisultato(Double risultato) {
		this.risultato = risultato;
	}

}
