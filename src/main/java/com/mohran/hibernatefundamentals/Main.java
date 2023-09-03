package com.mohran.hibernatefundamentals;

import com.mohran.hibernatefundamentals.airport.Payment;
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

        Ticket ticket = new Ticket();
        ticket.setNumber("AA12345");
        ticket.setOrigin("Sohag");
        ticket.setDestination("London");
        Payment payment = new Payment();
        payment.setTicket(ticket);
        payment.setAmount(200);
        em.persist(ticket);
        em.persist(payment);



        em.getTransaction().commit();
        emf.close();
    }
}
