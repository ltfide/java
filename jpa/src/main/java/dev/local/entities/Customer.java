package dev.local.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "primary_email")
    private String primaryEmail;

    private Boolean married;

    private Byte age;

    @Enumerated(EnumType.STRING)
    private CustomerType type;
}
