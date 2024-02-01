package org.example.api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.api.dto.request.CreateProductRequest;
import org.example.api.dto.response.ProductResponse;
import org.example.factory.ProductDomainFactory;
import org.example.service.ProductService;
import org.example.util.ObjectMapperUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;
    private final ObjectMapperUtil objectMapperUtil;
    private final ProductDomainFactory productDomainFactory;

    @GetMapping("")
    public List<ProductResponse> getAll() {
        return objectMapperUtil.mapAll(service.getAllProducts(), ProductResponse.class);
    }

    @GetMapping("{productId}")
    public ProductResponse get(@PathVariable long productId) {
        final var product = service.findById(productId);

        return objectMapperUtil.map(product, ProductResponse.class);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse create(@RequestBody @Valid CreateProductRequest request) {
        final var product = service.create(
                productDomainFactory.toCreate(request)
        );

        return objectMapperUtil.map(product, ProductResponse.class);
    }

    //TODO:: Adicionar método update()

    @DeleteMapping("{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long productId) {
        service.delete(productId);
    }

}
