package org.example.persistence.entity;


import jakarta.persistence.*;
import lombok.*;

@Table(name="product")
@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;
    private String name;
    private String description;
    private String image;
    private Float price;
    private Integer product_category_id;
    private Integer restaurant_id;

}
