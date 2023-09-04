package com.mohran.hibernatefundamentals;

import com.mohran.hibernatefundamentals.airport.Passenger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefundamentals.with.mohran");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Passenger mohran = new Passenger("mohamed mohran");
        mohran.setVip(true);

        Passenger ashraf = new Passenger("ahmed ahsraf")   ;
        ashraf.setVip(false);
        em.persist(mohran);
        em.persist(ashraf);

        em.getTransaction().commit();
        emf.close();
    }
}
