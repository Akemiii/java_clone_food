package org.example.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor(staticName = "of")
public class ProductResponse {
    private Long productId;
    private String name;
    private String description;
    private Float price;
    private String image;

}
