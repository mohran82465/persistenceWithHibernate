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
        Passenger mohran = new Passenger(1, "mohamed mohran");
         mohran.setCity("Sohag");
         mohran.setStreet("Akhmim");
         mohran.setZipCode("1234567");
         mohran.setNumber("7");

        em.persist(mohran);



        em.getTransaction().commit();
        emf.close();
    }
}
