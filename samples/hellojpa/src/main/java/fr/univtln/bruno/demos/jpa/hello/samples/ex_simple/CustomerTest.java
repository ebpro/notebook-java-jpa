package fr.univtln.bruno.demos.jpa.hello.samples.ex_simple;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CustomerTest {
    public static void main(String[] args) {

        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("hellojpa-pu")) {
            try (EntityManager entityManager = emf.createEntityManager()) {
                entityManager.getTransaction().begin();

                Customer customer = Customer.of("pierre.durand@ici.fr");
                System.out.println("BEFORE PERSIST " + customer.toString());

                entityManager.persist(customer);
                System.out.println("AFTER PERSIST: " + customer);

                customer.setName("Pierre");
                System.out.println("AFTER CHANGE: " + customer);

                entityManager.getTransaction().commit();

                try (EntityManager anotherEM = emf.createEntityManager()) {
                    System.out.println("Search Id 1: " + anotherEM.find(Customer.class, 1L));
                }

                entityManager.getTransaction().begin();
                entityManager.remove(customer);
                entityManager.getTransaction().commit();

                try (EntityManager anotherEntityManager = emf.createEntityManager()) {
                    System.out.println("After remove Search Id 1: " + anotherEntityManager.find(Customer.class, 1L));
                }

            }
        }
    }
}
