package fr.univtln.bruno.demos.jpa.hello.samples.ex_associations.ex_onetomanyA;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "EORDER", schema = "EX_ONE_TO_MANY_A")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private LocalDateTime date = LocalDateTime.now();

    @OneToMany(mappedBy = "order",
            cascade = {CascadeType.PERSIST,
                    CascadeType.REMOVE},
            orphanRemoval = true)
    private List<Line> lines = new ArrayList<>();

    public Order addLine(Line line) {
        line.setOrder(this);
        lines.add(line);
        return this;
    }

    public Order removeLine(Line line) {
        line.setOrder(this);
        lines.remove(line);
        return this;
    }
}
