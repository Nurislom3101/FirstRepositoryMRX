package com.company.Magazine.Marketplace.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "baskets")
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "basket_id")
    private Integer basketId;

    private int product_id;

    @Column(name = "prod_mass")
    private Double prod_mass;

    @Column(name = "prod_price")
    private Double prod_price;

    @Column(name = "total_price")
    private Double total_price;

    @Column(name = "created_at")
    private Timestamp created_at;

    @Column(name = "updated_at")
    private Timestamp updated_at;

    @Column(name = "deleted_at")
    private Timestamp deletedAt;

    @OneToMany(mappedBy = "basket_id", cascade = CascadeType.ALL)
    private Set<Product> product;

    @OneToMany(mappedBy = "basket_id", cascade = CascadeType.ALL)
    private Set<Loaner> loaners;




}
