package fr.univtln.bruno.demos.jpa;

import fr.univtln.bruno.demos.jpa.orders.CatalogItem;
import fr.univtln.bruno.demos.jpa.orders.Customer;
import fr.univtln.bruno.demos.jpa.orders.CustomerOrder;
import fr.univtln.bruno.demos.jpa.orders.CustomerOrderLine;
import fr.univtln.bruno.demos.jpa.orders.paiement.CreditCardTransaction;
import fr.univtln.bruno.demos.jpa.orders.paiement.SwiftTransfer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Id;
import jakarta.persistence.Persistence;
import lombok.extern.java.Log;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Main class.
 */
@Log
public class Main {


    /**
     * Main method.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        EntityManager em = DatabaseManager.emf.createEntityManager();

        em.getTransaction().begin();

        List<Customer> customerList = List.of(
                Customer.builder().firstname("Pierre").lastname("Durand").email("p.durand@ici.fr").build(),
                Customer.builder().firstname("Marie").lastname("Dupont").email("m.dupont@ici.com").build(),
                Customer.builder().firstname("Jacques").lastname("Petit").email("j.petit@la.org").build());
        customerList.forEach(em::persist);

        List<CatalogItem> catalogItems = List.of(
                CatalogItem.builder().name("Pêche").unitPrice(10).build(),
                CatalogItem.builder().name("Pomme").unitPrice(20).build(),
                CatalogItem.builder().name("Poire").unitPrice(30).build());
        catalogItems.forEach(em::persist);

        CustomerOrder order = new CustomerOrder(customerList.get(0));
        order.addCustomerOrderLine(CustomerOrderLine.builder().item(catalogItems.get(0)).quantity(1).build());
        order.addCustomerOrderLine(CustomerOrderLine.builder().item(catalogItems.get(1)).quantity(3).build());
        order.addCustomerOrderLine(CustomerOrderLine.builder().item(catalogItems.get(1)).quantity(5).build());
        em.persist(order);


        em.persist(CreditCardTransaction.builder()
                .amount(100)
                .number("NC1")
                .outgoingAcquirerNumber("OAN-NC1-1")
                .type(CreditCardTransaction.CardType.VISA)
                .expiration(new Date())
                .customerOrder(order)
                .build());
        em.persist(SwiftTransfer.builder()
                .amount(50)
                .customerOrder(order)
                .build());

        log.info(order.toString());

        em.getTransaction().commit();

        em.createNamedQuery("CustomerOrder.findAll", CustomerOrder.class).getResultList().stream().map(Object::toString).forEach(log::info);

        log.info("lines " + em.find(CustomerOrder.class, 1L).getLines().size());

        log.info(em.createNamedQuery("Customer.findAll", Customer.class).getResultList().toString());

    }
}

