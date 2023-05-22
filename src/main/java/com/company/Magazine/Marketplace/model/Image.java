package com.company.Magazine.Marketplace.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "image_id")
    private Integer imageId;

    @Column(name = "image_path")
    private String image_path;

    @Column(name = "image_type")
    private String image_type;

    @Column(name = "image_size")
    private int image_size;

    @Column(name = "image_token")
    private String image_token;

    @Column(name = "created_at")
    private Timestamp created_at;

    @Column(name = "updated_at")
    private Timestamp updated_at;

    @Column(name = "deleted_at")
    private Timestamp deletedAt;



    @Column(name = "product_id")
    private Integer product_id;

    @OneToOne(mappedBy = "image")
    private Product product;


    @Column(name = "user_id")
    private Integer user_id;

    @OneToOne(mappedBy = "image")
    private User user;
}
