package fr.univtln.bruno.demos.jpa.orders.paiement;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(callSuper = true)
@SuperBuilder
@NoArgsConstructor
public class SwiftTransfer extends Payment{
    @Column(unique = true)
    private String UETR;
}
