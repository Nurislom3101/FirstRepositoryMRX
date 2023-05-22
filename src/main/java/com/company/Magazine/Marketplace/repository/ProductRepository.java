package com.company.Magazine.Marketplace.repository;

import com.company.Magazine.Marketplace.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface ProductRepository extends JpaRepository<Product,Integer> {

    Optional<Product> findByProductIdAndDeletedAtIsNull(Integer id);
}
