package com.company.Magazine.Marketplace.repository;

import com.company.Magazine.Marketplace.model.Loaner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface LoanerRepository extends JpaRepository<Loaner,Integer> {

    Optional<Loaner> findByLoanerIdAndDeletedAtIsNull(Integer id);
}
