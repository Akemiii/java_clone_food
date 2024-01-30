package org.example.api.controller;

import lombok.RequiredArgsConstructor;
import org.example.api.dto.response.ProductResponse;
import org.example.service.ProductService;
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

    @Autowired
    private ProductService productService;

    @GetMapping("")
    public List<ProductResponse> getAll() {

        return productService.getAllProducts()
                .stream()
                .map(product -> ProductResponse.of(product.getProductId(), product.getName(),
                        product.getDescription(), product.getPrice(), product.getImage()))
                .toList();
    }

    @GetMapping("{productId}")
    public ProductResponse get(@PathVariable long productId) {
       final var product = productService.findById(productId);

       return ProductResponse.of(product.getProductId(), product.getName(), product.getDescription(), product.getPrice(), product.getImage());
    }
}
