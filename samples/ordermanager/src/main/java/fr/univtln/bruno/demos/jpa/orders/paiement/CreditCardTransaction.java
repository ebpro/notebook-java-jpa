package fr.univtln.bruno.demos.jpa.orders.paiement;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(callSuper = true)
@SuperBuilder
@NoArgsConstructor
public class CreditCardTransaction extends Payment {
    public enum CardType {VISA, MASTERCARD}

    @Column(unique = true, nullable = false)
    private String outgoingAcquirerNumber;

    @Column(nullable = false)
    private CardType type;

    @Column(nullable = false)
    private String number;

    @Column(nullable = false)
    private Date expiration;
}
