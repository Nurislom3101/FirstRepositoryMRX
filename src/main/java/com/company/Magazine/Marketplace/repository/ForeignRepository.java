package com.company.Magazine.Marketplace.repository;

import com.company.Magazine.Marketplace.model.Foreign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface ForeignRepository extends JpaRepository<Foreign,Integer> {

    Optional<Foreign> findByForeignIdAndDeletedAtIsNull(Integer id);
}
