package dev.local.entities;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Name {

    private String title;
    private String firstName;
    private String lastName;
}
