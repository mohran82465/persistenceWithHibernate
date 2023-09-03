package com.mohran.hibernatefundamentals;

import com.mohran.hibernatefundamentals.airport.Address;
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
        Passenger mohran = new Passenger("mohamed mohran") ;
        Address address = new Address();

        address.setStreet("Akhmim st");
        address.setNumber("7");
        address.setZipCode("1234567");
        address.setCity("Sohag");
        mohran.setAddress(address);
        em.persist(mohran);
        

        em.getTransaction().commit();
        emf.close();
    }
}
