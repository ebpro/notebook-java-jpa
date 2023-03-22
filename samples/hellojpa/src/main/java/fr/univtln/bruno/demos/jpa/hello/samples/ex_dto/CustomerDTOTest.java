package fr.univtln.bruno.demos.jpa.hello.samples.ex_dto;

import fr.univtln.bruno.demos.jpa.hello.DatabaseManager;
import fr.univtln.bruno.demos.jpa.hello.samples.ex_entity.CustomerGenerator;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class CustomerDTOTest {
    public static void main(String[] args) {

        try (EntityManager entityManager = DatabaseManager.ENTITY_MANAGER_FACTORY.createEntityManager()) {
            CustomerGenerator.generateCustomer(10);
            TypedQuery<CustomerDisplayDTO> query = entityManager.createQuery("""
                            SELECT new fr.univtln.bruno.demos.jpa.hello.samples.ex_dto.CustomerDisplayDTO(c.firstname, c.lastname)
                            FROM Customer c""",
                    CustomerDisplayDTO.class);

            query.setMaxResults(5).getResultList().stream().forEach(System.out::println);

        }

    }
}
