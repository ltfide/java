package dev.local.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "credentials")
public class Credential {

    @Id
    private String id;

    private String email;

    private String password;

    @OneToOne(mappedBy = "credential")
    private User user;
}
