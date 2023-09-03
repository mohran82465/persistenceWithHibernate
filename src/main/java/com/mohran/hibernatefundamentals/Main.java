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
        Passenger ashraf = new Passenger("ahmed ashraf");

        Ticket ticket1 = new Ticket("AA1234");
        Ticket ticket2 = new Ticket("BB5678");

        mohran.addTicket(ticket1);
        mohran.addTicket(ticket2);

        ashraf.addTicket(ticket1);
        ashraf.addTicket(ticket2);

        ticket1.addPassenger(mohran);
        ticket1.addPassenger(ashraf);
        ticket2.addPassenger(mohran);
        ticket2.addPassenger(ashraf);


        em.persist(mohran);
        em.persist(ticket1);
        em.persist(ashraf);
        em.persist(ticket2);

        em.getTransaction().commit();
        emf.close();
    }
}
