package fr.univtln.bruno.demos.jpa.hello.samples.ex_associations.ex_onetomanyB;

import fr.univtln.bruno.demos.jpa.hello.DatabaseManager;
import jakarta.persistence.EntityManager;

public class TestOnetoMany {
    public static void main(String[] args) {
        Order order021 = Order.builder()
                .line(Line.of("Pen", 1.0))
                .line(Line.of("Paper", 5.0))
                .build();
        Order order022 = Order.builder()
                .line(Line.of("Car", 20000))
                .line(Line.of("Moto", 8000))
                .build();

        try (EntityManager entityManager = DatabaseManager
                .ENTITY_MANAGER_FACTORY.createEntityManager()) {
            entityManager.getTransaction().begin();
            entityManager.persist(order021);
            entityManager.persist(order022);
            entityManager.getTransaction().commit();
        }

        try (EntityManager entityManager = DatabaseManager
                .ENTITY_MANAGER_FACTORY.createEntityManager()) {
            System.out.println(entityManager.find(Order.class, 1L));
        }


    }
}
