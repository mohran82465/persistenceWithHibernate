package com.mohran.hibernatefundamentals;

import com.mohran.hibernatefundamentals.airport.Airport;
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

        Airport airport = new Airport(1 , "Sohag") ;
        Passenger mohran =  new Passenger(1,"mohamed mohran");
        mohran.setAirport(airport);
        Passenger ashraf = new Passenger(2, "ahmed ashraf");
        ashraf.setAirport(airport);
        airport.addPassengers(mohran);
        airport.addPassengers(ashraf);

        Ticket ticket1 = new Ticket(1,"AA123467");
        ticket1.setPassenger(mohran);
        Ticket ticket2 = new Ticket(2,"BB456789") ;
        ticket2.setPassenger(mohran);
        mohran.addTicket(ticket1);
        mohran.addTicket(ticket2);
        Ticket ticket3 = new Ticket(3,"CC098765");
        ticket3.setPassenger(ashraf);
        ashraf.addTicket(ticket3);

        em.persist(airport);
        em.persist(mohran);
        em.persist(ashraf);

        em.persist(ticket1);
        em.persist(ticket2);
        em.persist(ticket3);

        em.getTransaction().commit();
        emf.close();
    }
}
