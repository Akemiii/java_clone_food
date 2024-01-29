package org.example.api.controller;

import org.example.persistence.entity.Product;
import org.example.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping("/{productId}")
    public void getProductById(@PathVariable long productId) {
       // return productService.findById(id);
    }
}
