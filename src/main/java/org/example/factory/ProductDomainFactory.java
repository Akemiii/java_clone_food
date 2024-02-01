package org.example.factory;

import org.example.api.dto.request.CreateProductRequest;
import org.example.domain.ProductDomain;
import org.springframework.stereotype.Component;

@Component
public class ProductDomainFactory {

    public ProductDomain toCreate(final CreateProductRequest request) {
        return ProductDomain.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .image(request.getImage())
                .build();
    }
}
