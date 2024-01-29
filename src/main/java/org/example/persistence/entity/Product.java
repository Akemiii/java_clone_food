package org.example.persistence.entity;


import jakarta.persistence.*;
import lombok.*;

@Table(name="product")
@Entity(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String name;
    private String description;
    private String image;
    private Float price;
    private Integer product_category_id;
    private Integer restaurant_id;


}
