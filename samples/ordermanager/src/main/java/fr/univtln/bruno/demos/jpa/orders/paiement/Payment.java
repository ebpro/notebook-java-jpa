package fr.univtln.bruno.demos.jpa.orders.paiement;

import fr.univtln.bruno.demos.jpa.orders.CustomerOrder;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@ToString
@SuperBuilder
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_seq")
    private long id;

    @Column(nullable = false)

    private float amount;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ORDER_FK")
    private CustomerOrder customerOrder;
}
