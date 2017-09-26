package com.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "corsi")
public class Corso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int anno;

    @Column
    private String facolta;

    public Corso() {}

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public int getAnno() {

        return anno;
    }

    public void setAnno(int anno) {

        this.anno = anno;
    }

    public String getFacolta() {

        return facolta;
    }

    public void setFacolta(String facolta) {

        this.facolta = facolta;
    }

}
