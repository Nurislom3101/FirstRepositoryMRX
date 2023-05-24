package com.company.Magazine.Marketplace.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "foreign_debt")
public class Foreign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "foreign_id")
    private Integer foreignId;

    @Column(name = "foreign_company_name")
    private String foreign_company_name;

    @Column(name = "foreign_full_name")
    private String foreign_fullName;

    @Column(name = "foreign_first_phone_number")
    private String foreign_first_phone_number;

    @Column(name = "foreign_second_phone_number")
    private String foreign_second_phone_number;

    @Column(name = "foreign_status")
    private Boolean foreign_status;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Column(name = "deleted_at")
    private Timestamp deletedAt;

    @OneToMany(mappedBy = "productId", cascade = CascadeType.ALL)
    private Set<Product> product;

}
