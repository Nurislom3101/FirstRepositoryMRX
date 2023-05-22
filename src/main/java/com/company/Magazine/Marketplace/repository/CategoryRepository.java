package com.company.Magazine.Marketplace.repository;

import com.company.Magazine.Marketplace.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    Optional<Category> findByCategoryIdAndDeletedAtIsNull(Integer id);

}
