package com.company.Magazine.Marketplace.repository;

import com.company.Magazine.Marketplace.model.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface BasketRepository extends JpaRepository<Basket,Integer> {

Optional<Basket> findByBasketIdAndDeletedAtIsNull(Integer id);

}
