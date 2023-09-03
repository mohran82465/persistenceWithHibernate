package com.mohran.hibernatefundamentals;

import com.mohran.hibernatefundamentals.airport.Passenger;
import com.mohran.hibernatefundamentals.airport.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Table;

public class Main {
    public static void main(String[] args)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefundamentals.with.mohran");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Passenger mohran = new Passenger("mohamed morhan");

        Ticket ticket1 = new Ticket("AA12345");
        Ticket ticket2 = new Ticket("BB67890");

        mohran.addTicket(ticket1);
        mohran.addTicket(ticket2);
        em.persist(mohran );


        em.getTransaction().commit();
        emf.close();
    }
}
