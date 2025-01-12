package dev.local.entities.isa;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("MANAGER")
public class Manager extends Employee {

    @Column(name = "total_employee")
    private int totalEmployee;
}
