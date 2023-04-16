package com.local;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude = "price")
@AllArgsConstructor
public class Product {

    private String id;

    private String name;

    private Long price;
}
