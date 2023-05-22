package com.company.Magazine.Marketplace.repository;

import com.company.Magazine.Marketplace.model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface EmployeesRepository extends JpaRepository<Employees,Integer> {
    Optional<Employees> findByEmployeesIdAndDeletedAtIsNull(Integer id);
}
