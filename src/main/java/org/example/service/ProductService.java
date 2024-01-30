package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.domain.ProductDomain;
import org.example.exception.NotFoundException;
import org.example.persistence.entity.Product;
import org.springframework.stereotype.Service;
import org.example.persistence.repository.ProductRepository;

import java.util.List;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public List<ProductDomain> getAllProducts() {
       return repository.findAll()
               .stream()
               .map(mapProdutToDomain())
               .toList();
    }

    public ProductDomain findById(long productId) {
        return repository.findById(productId)
                .map(mapProdutToDomain())
                .orElseThrow(NotFoundException::new);
    }

    private Function<Product, ProductDomain> mapProdutToDomain() {
        return product -> ProductDomain.builder()
                .productId(product.getProductId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .image(product.getImage())
                .build();

    }

    private Function<ProductDomain, Product> mapDomainToProduct() {
        return product -> Product.builder()
                .productId(product.getProductId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .image(product.getImage())
                .build();
    }
}
