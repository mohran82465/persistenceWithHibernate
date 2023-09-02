package com.mohran.hibernatefundamentals;

import com.mohran.hibernatefundamentals.airport.Passenger;
import com.mohran.hibernatefundamentals.airport.Ticket;
import com.mohran.hibernatefundamentals.airport.TicketKey;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefundamentals.with.mohran");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Ticket ticket = new Ticket();
        ticket.setSeries("AA");
        ticket.setNumber("12345");

        ticket.setOrigin("Sohag");
        ticket.setDestination("London");
        em.persist(ticket);


        em.getTransaction().commit();
        emf.close();
    }
}
