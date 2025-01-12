package dev.local.entities.isa;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("VP")
public class VicePresident extends Employee {

    @Column(name = "total_manager")
    private int totalManager;
}
