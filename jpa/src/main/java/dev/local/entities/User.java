package dev.local.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    private String id;

    private String name;

    @OneToOne
    @PrimaryKeyJoinColumn(
            name = "id",
            referencedColumnName = "id"
    )
    private Credential credential;

    @OneToOne(mappedBy = "user")
    private Wallet wallet;
}
