package fr.univtln.bruno.demos.jpa;

import fr.univtln.bruno.demos.jpa.orders.CustomerOrder;
import jakarta.persistence.EntityManager;
import lombok.extern.java.Log;

@Log
public class Query {

    public static void main(String[] args) {
        EntityManager em = DatabaseManager.emf.createEntityManager();

        em.createNamedQuery("CustomerOrder.findAll", CustomerOrder.class).getResultList().stream().map(Object::toString).forEach(log::info);

    }
}
