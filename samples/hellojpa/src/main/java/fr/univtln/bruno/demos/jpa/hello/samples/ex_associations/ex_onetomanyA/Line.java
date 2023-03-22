package fr.univtln.bruno.demos.jpa.hello.samples.ex_associations.ex_onetomanyA;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@RequiredArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "LINE", schema = "EX_ONE_TO_MANY_A")
public class Line {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @NonNull
    private String product;
    @NonNull
    private double price;

    @ManyToOne
    @JoinColumn(nullable = false)
    @Setter
    @ToString.Exclude
    private Order order;
}
