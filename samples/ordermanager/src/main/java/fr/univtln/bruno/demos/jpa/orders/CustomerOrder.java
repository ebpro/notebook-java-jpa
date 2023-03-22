package fr.univtln.bruno.demos.jpa.orders;

import fr.univtln.bruno.demos.jpa.orders.paiement.Payment;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
//@Builder
@NoArgsConstructor
@Table(name = "CUSTOMER_ORDER")
@NamedQuery(name = "CustomerOrder.findAll", query = "select co from CustomerOrder co")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "custorder_seq")
    @EqualsAndHashCode.Include
    private long id;

    public CustomerOrder(Customer buyer) {
        this.buyer = buyer;
    }

    @Embedded
    //@Builder.Default
    OrderStatus status = new OrderStatus();

    //@Builder.Default
    private Date creationDate=new Date();

    @ManyToOne
    @JoinColumn(name = "BUYER_FK",nullable = false)
    private Customer buyer;

    @OneToMany(mappedBy = "customerOrder",
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            orphanRemoval = true)
    private List<CustomerOrderLine> lines = new ArrayList<>();
    public void addCustomerOrderLine(CustomerOrderLine customerOrderLine) {
        lines.add(customerOrderLine);
        customerOrderLine.setCustomerOrder(this);
    }
    public void removeCustomerOrderLine(CustomerOrderLine customerOrderLine) {
        lines.remove(customerOrderLine);
        customerOrderLine.setCustomerOrder(null);
    }

    @OneToMany(mappedBy = "customerOrder")
    private List<Payment> payments;

}
