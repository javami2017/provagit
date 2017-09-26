package com.hibernate;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "studenti")
public class Studente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int matricola;

    @Column
    private String nome;

    @Column
    private String cognome;

    @ManyToMany(cascade = CascadeType.ALL)
    /* Creo una tabella intermedia studenti-corsi e specifico le colonne in
     * relazione che dovranno essere uguali alle chiavi primarie delle
     * respettive tabelle */
    // @JoinTable(name = "STUDENTI_CORSI", joinColumns = { @JoinColumn(name =
    // "ID_STUDENTE") }, inverseJoinColumns = { @JoinColumn(name = "ID_CORSO")
    // })
    @JoinTable(joinColumns = { @JoinColumn(name="studente_matricola", foreignKey = @ForeignKey(name = "fk__studente_matricola__studenti_matricola")) }, inverseJoinColumns = { @JoinColumn(name="corso_id", foreignKey = @ForeignKey(name = "fk__corso_id__corsi_id")) })
    private List<Corso> corsi; /* Creo l'oggetto di collegamento corsi laurea */

   //@formatter:off
	@ManyToOne
	@JoinColumn(name = "indirizzo_id", foreignKey = @ForeignKey(name = "fk__studenti_indirizzo_id__indirizzi_id")) // che viene persistita in questa tabella   <--..__
	private Indirizzo indirizzo;                                                                                   // si collega a questo nome della variabile _______|
	//@formatter:on

    public int getMatricola() {

        return matricola;
    }

    public void setMatricola(int matricola) {

        this.matricola = matricola;
    }

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

    public String getCognome() {

        return cognome;
    }

    public void setCognome(String cognome) {

        this.cognome = cognome;
    }

    public List<Corso> getCorsi() {

        return corsi;
    }

    public void setCorsi(List<Corso> corsi) {

        this.corsi = corsi;
    }

    public Indirizzo getIndirizzo() {

        return indirizzo;
    }

    public void setIndirizzo(Indirizzo indirizzo) {

        this.indirizzo = indirizzo;
    }

}
