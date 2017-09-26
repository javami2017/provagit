package com.hibernate;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "indirizzi")
public class Indirizzo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String strada;

    @Column
    private int civico;

    @Column
    private String citta;

    /* il campo indirizzo si collega a studente */
    @OneToMany(mappedBy = "indirizzo")
    private List<Studente> studente;

    public Indirizzo() {}

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getStrada() {

        return strada;
    }

    public void setStrada(String strada) {

        this.strada = strada;
    }

    public int getCivico() {

        return civico;
    }

    public void setCivico(int civico) {

        this.civico = civico;
    }

    public String getCitta() {

        return citta;
    }

    public void setCitta(String citta) {

        this.citta = citta;
    }

    public List<Studente> getStudente() {

        return studente;
    }

    public void setStudente(List<Studente> studente) {

        this.studente = studente;
    }

}
