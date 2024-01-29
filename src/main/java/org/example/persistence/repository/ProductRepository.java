package org.example.persistence.repository;

import org.example.persistence.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByName(String name);

    Product findFirstById(Long id);

}
