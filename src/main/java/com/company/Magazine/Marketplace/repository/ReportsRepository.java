package com.company.Magazine.Marketplace.repository;

import com.company.Magazine.Marketplace.model.Reports;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface ReportsRepository extends JpaRepository<Reports,Integer> {

    Optional<Reports> findByReportsIdAndDeletedAtIsNull(Integer id);
}
