package dev.local.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "brands")
public class Brand {

    @Id
    private String id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "brand")
    private List<Product> products;
}
