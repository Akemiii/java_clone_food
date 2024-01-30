package org.example.api.controller;

import lombok.RequiredArgsConstructor;
import org.example.api.dto.response.ProductResponse;
import org.example.service.ProductService;
import org.example.util.ObjectMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {

    private ProductService productService;
    private ObjectMapperUtil objectMapperUtil;

    @GetMapping("")
    public List<ProductResponse> getAll() {
        return objectMapperUtil.mapAll(productService.getAllProducts(), ProductResponse.class);
    }

    @GetMapping("{productId}")
    public ProductResponse get(@PathVariable long productId) {
       final var product = productService.findById(productId);

       return objectMapperUtil.map(product, ProductResponse.class);
    }

    //TODO:: Adicionar Create() e Update()
}
