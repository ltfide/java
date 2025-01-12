package dev.local.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {

    @Id
    private String id;
    private String name;
    private Long price;

    @ManyToOne
    @JoinColumn(
            name = "brand_id",
            referencedColumnName = "id"
    )
    private Brand brand;
}
