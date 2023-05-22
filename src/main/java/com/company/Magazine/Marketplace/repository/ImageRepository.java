package com.company.Magazine.Marketplace.repository;

import com.company.Magazine.Marketplace.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface ImageRepository extends JpaRepository<Image,Integer> {

    Optional<Image> findByImageIdAndDeletedAtIsNull(Integer id);
}
