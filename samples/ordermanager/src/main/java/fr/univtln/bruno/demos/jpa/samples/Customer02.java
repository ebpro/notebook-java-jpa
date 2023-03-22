package fr.univtln.bruno.demos.jpa.samples;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Calendar;

@Entity
@Data
@Table(name = "CUSTOMER_02")
public class Customer02 {
    @Id
    @Column(name="ID")
    @GeneratedValue
    private long id;

    @Column(length=50, nullable=false, unique = true)
    private String email;

    @Column(length=50, nullable=false)
    private String name;

    @Transient
    private int age;

    @Temporal(TemporalType.DATE)
    private Calendar birthDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable=false)
    private Calendar creationDate;

    @Lob
    @Basic(fetch=FetchType.LAZY)
    private byte[] photo;

}
