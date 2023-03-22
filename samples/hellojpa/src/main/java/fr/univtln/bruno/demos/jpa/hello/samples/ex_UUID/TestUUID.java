package fr.univtln.bruno.demos.jpa.hello.samples.ex_UUID;

import fr.univtln.bruno.demos.jpa.hello.DatabaseManager;
import jakarta.persistence.EntityManager;
import net.datafaker.Faker;

import java.util.stream.Stream;

public class TestUUID {
    public static void main(String[] args) {
        try (EntityManager entityManager = DatabaseManager.ENTITY_MANAGER_FACTORY.createEntityManager()) {
            entityManager.getTransaction().begin();

            Faker faker = new Faker();

            Stream.generate(() -> {
                String fullname = faker.name().fullName();
                return Customer.of(fullname);
            }).limit(5).forEach(entityManager::persist);

            entityManager.getTransaction().commit();

            entityManager.createQuery("""
                    SELECT c 
                    FROM CustomerUUID c""")
                    .setMaxResults(5)
                    .getResultStream()
                    .forEach(System.out::println);
        }
    }
}
