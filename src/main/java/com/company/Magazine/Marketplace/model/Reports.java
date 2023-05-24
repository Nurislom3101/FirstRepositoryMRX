package com.company.Magazine.Marketplace.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "reports")
public class Reports {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "reports_id")
    private Integer reportsId;

    private int category_id;

    @Column(name = "prod_name")
    private String prodName;

    @Column(name = "prod_present")
    private Double prod_present;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Column(name = "deleted_at")
    private Timestamp deletedAt;

    @OneToMany(mappedBy = "categoryId", cascade = CascadeType.ALL)
    private Set<Category> category;

}
