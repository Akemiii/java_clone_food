package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.domain.ProductDomain;
import org.example.exception.NotFoundException;
import org.example.util.ObjectMapperUtil;
import org.springframework.stereotype.Service;
import org.example.persistence.repository.ProductRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;
    private final ObjectMapperUtil objectMapperUtil;

    public List<ProductDomain> getAllProducts() {
        return objectMapperUtil.mapAll(
                repository.findAll(), ProductDomain.class
        );
    }

    public ProductDomain findById(long productId) {
        return repository.findById(productId)
                .map(objectMapperUtil.mapFn(ProductDomain.class))
                .orElseThrow(NotFoundException::new);
    }

}
