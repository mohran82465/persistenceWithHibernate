package com.mohran.hibernatefundamentals;

import com.mohran.hibernatefundamentals.airport.Passenger;
import com.mohran.hibernatefundamentals.airport.Ticket;

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
        Ticket ticket1 = new Ticket("AA1234");
        ticket1.setPassenger(mohran);

        Ticket ticket2 = new Ticket("BB5678");
        ticket2.setPassenger(mohran);

        mohran.addTicket(ticket1);
        mohran.addTicket(ticket2);

        em.persist(mohran);
        em.persist(ticket1);
        em.persist(ticket2);

        em.getTransaction().commit();
        emf.close();
    }
}
