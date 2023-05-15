package com.company.Magazine.Marketplace.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "foreign_debt")
public class Foreign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer foreign_id;

    private int product_id;

    @Column(name = "foreign_company_name")
    private String foreign_company_name;

    @Column(name = "foreign_fullName")
    private String foreign_fullName;

    @Column(name = "foreign_first_phone_number")
    private String foreign_first_phone_number;

    @Column(name = "foreign_second_phone_number")
    private String foreign_second_phone_number;

    @Column(name = "foreign_status")
    private Boolean foreign_status;

    @Column(name = "created_at")
    private Timestamp created_at;

    @Column(name = "updated_at")
    private Timestamp updated_at;

    @Column(name = "deleted_at")
    private Timestamp deleted_at;

}
