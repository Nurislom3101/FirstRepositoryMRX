package com.company.Magazine.Marketplace.repository;

import com.company.Magazine.Marketplace.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findByUserIdAndDeletedAtIsNull(Integer id);
}
