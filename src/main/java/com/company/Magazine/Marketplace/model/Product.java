package com.company.Magazine.Marketplace.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer product_id;

    @Column(name = "prod_name")
    private String prod_name;

    @Column(name = "received_price")
    private Double received_price;

    @Column(name = "selling_price")
    private Double selling_price;

    @Column(name = "prod_mass")
    private Double prod_mass;

    @Column(name = "prod_amount")
    private Double prod_amount;

    @Column(name = "image_id")
    private int image_id;

    @Column(name = "expired_at")
    private Timestamp expired_at;

    @Column(name = "created_at")
    private Timestamp created_at;

    @Column(name = "updated_at")
    private Timestamp updated_at;

    @Column(name = "deleted_at")
    private Timestamp deleted_at;

}
