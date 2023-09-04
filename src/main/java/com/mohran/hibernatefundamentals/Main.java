package com.mohran.hibernatefundamentals;

import com.mohran.hibernatefundamentals.airport.OneWayTicket;
import com.mohran.hibernatefundamentals.airport.Passenger;
import com.mohran.hibernatefundamentals.airport.ReturnTicket;
import org.hibernate.loader.collection.OneToManyJoinWalker;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefundamentals.with.mohran");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        OneWayTicket oneWayTicket = new OneWayTicket();
        oneWayTicket.setNumber("AA12345");
        oneWayTicket.setLatestDepartureDate(LocalDate.of(2023,9,20));

        ReturnTicket returnTicket = new ReturnTicket()  ;
        returnTicket.setNumber("BB56789");
        returnTicket.setLatestReturnDate(LocalDate.of(2024,1,22  ));
 
        em.persist(oneWayTicket);
        em.persist(returnTicket);

        em.getTransaction().commit();
        emf.close();
    }
}
