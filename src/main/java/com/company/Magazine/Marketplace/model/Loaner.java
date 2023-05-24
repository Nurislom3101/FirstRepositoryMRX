package com.company.Magazine.Marketplace.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "loaner")
public class Loaner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "loaner_id")
    private Integer loanerId;

    private int basked_id;

    @Column(name = "total_price")
    private Double total_price;

    @Column(name = "loaner_status")
    private Boolean loaner_status;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Column(name = "deleted_at")
    private Timestamp deletedAt;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @Column(name = "basket_id")
    private Integer basket_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "basket_id", insertable = false, updatable = false)
    private Basket basket;
}
