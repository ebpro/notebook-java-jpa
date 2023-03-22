package fr.univtln.bruno.demos.jpa.orders;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@NamedQuery(name = "Customer.findAll", query = "select c from Customer c")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
    private long id;

    @Column(unique = true, nullable = false)
    @EqualsAndHashCode.Include
    private String email;
    private String firstname;
    private String lastname;

    @ToString.Exclude
    private String address;

    @OneToMany(mappedBy = "buyer")
    private List<CustomerOrder> customerOrders = new ArrayList<>();
}
