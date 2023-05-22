package com.company.Magazine.Marketplace.model;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "category_id")
    private Integer categoryId;

    private int product_id;

    @Column(name = "category_name")
    private String category_name;

    @Column(name = "created_at")
    private Timestamp created_at;

    @Column(name = "updated_at")
    private Timestamp updated_at;

    @Column(name = "deleted_at")
    private Timestamp deletedAt;

    @OneToMany(mappedBy = "category_id", cascade = CascadeType.ALL)
    private Set<Product> product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reports_id", insertable = false, updatable = false)
    private Foreign foreign;
}
