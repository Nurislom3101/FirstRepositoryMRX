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

    @Column(name = "product_id")
    private Integer productId;

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
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Column(name = "deleted_at")
    private Timestamp deletedAt;

    @Column(name = "basket_id")
    private Integer basket_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "basket_id", insertable = false, updatable = false)
    private Basket baskets;

    @Column(name = "category_id")
    private Integer category_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    private Category categories;

    @Column(name = "foreign_id")
    private Integer foreign_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "foreign_id", insertable = false, updatable = false)
    private Foreign foreign;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Image image;

}
