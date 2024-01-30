package org.example.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductDomain {
    private Long productId;
    private String name;
    private String description;
    private String image;
    private Float price;
    private Integer product_category_id;
    private Integer restaurant_id;
}
