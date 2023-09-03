package com.mohran.hibernatefundamentals;

import com.mohran.hibernatefundamentals.airport.Department;
import com.mohran.hibernatefundamentals.airport.Manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefundamentals.with.mohran");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Manager mohran = new Manager("mohamed mohran");
        Department software = new Department();
        software.setName("Software");
        mohran.setDepartment(software);

        em.persist(mohran);
        em.persist(software);



        em.getTransaction().commit();
        emf.close();
    }
}
