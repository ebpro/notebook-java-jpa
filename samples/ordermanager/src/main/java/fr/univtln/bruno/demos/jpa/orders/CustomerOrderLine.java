package fr.univtln.bruno.demos.jpa.orders;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "CUSTOMER_ORDER_LINE")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CustomerOrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderline_seq")
    @EqualsAndHashCode.Include
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEM_FK", nullable = false)
    private CatalogItem item;

    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER_ORDER_FK", nullable = false)
    @ToString.Exclude
    private CustomerOrder customerOrder;
}
