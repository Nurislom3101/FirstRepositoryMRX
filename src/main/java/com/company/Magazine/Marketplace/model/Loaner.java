package com.company.Magazine.Marketplace.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "loaner")
public class Loaner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer loaner_id;

    private int basked_id;

    @Column(name = "total_price")
    private Double total_price;

    @Column(name = "loaner_status")
    private Boolean loaner_status;

    @Column(name = "created_at")
    private Timestamp created_at;

    @Column(name = "updated_at")
    private Timestamp updated_at;

    @Column(name = "deleted_at")
    private Timestamp deleted_at;
}
