package dev.local.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {

    @Id
    private String id;
    private String name;
    private Long price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "brand_id",
            referencedColumnName = "id"
    )
    private Brand brand;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "likes")
    private Set<User> likedBy;
}
