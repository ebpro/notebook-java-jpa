package fr.univtln.bruno.demos.jpa.orders;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.util.Date;

@Embeddable
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class    OrderStatus {
    public enum State {SUBMITTED, SHIPPED, DELIVERED}
    private State state = State.SUBMITTED;
    private Date lastChange = new Date();

    public void setState(State state) {
        lastChange = new Date();
        this.state = state;
    }
}
