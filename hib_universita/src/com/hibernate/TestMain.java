package com.hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;

public class TestMain {

    public static void main(String[] args) throws InterruptedException {

        // Recupero la sessione: attenzione, questa operazione
        // può essere gestita come un Singleton lungo tutta l’applicazione
        Session session = HibernateUtil.getCurrentSession();

        Indirizzo indirizzo_1 = new Indirizzo();

        indirizzo_1.setCitta("roma");
        indirizzo_1.setCivico(12);
        indirizzo_1.setStrada("via roma");

        Corso corso_1 = new Corso();

        corso_1.setAnno(1980);
        corso_1.setFacolta("informatica");

        Corso corso_2 = new Corso();

        corso_2.setAnno(1999);
        corso_2.setFacolta("elettronica");

        List<Corso> list = new ArrayList<Corso>();
        list.add(corso_2);
        list.add(corso_1);

        Studente studente_1 = new Studente();
        studente_1.setNome("Marco");
        studente_1.setCognome("Rossi");
        studente_1.setCorsi(list);
        studente_1.setIndirizzo(indirizzo_1);

        // Utilizziamo un modello transazionale dichiarativo. Gli dico che sto
        // per
        // cominciare a dargli gli oggetti da salvare
        session.beginTransaction();

        // Chiedo al middleware di salvare questo oggetto nel database
        session.persist(indirizzo_1);
        session.persist(corso_1);
        session.persist(corso_2);
        session.persist(studente_1);

        // fine della transazione: salviamo tramite commit()
        session.getTransaction().commit();

        Scanner scn = new Scanner(System.in);

        while (true) {
            System.out.println("program is running, waiting for 'x' to terminate...");
            if (scn.nextLine().equals("x")) break;
            Thread.sleep(2000);
        }

        scn.close();

        HibernateUtil.closeFactory();

    }

}
