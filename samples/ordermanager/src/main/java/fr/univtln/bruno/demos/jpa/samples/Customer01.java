package fr.univtln.bruno.demos.jpa.samples;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class Customer01 {
    @Id
    private long id;
    private String email;
    private String firstname;
    private String lastname;
}
