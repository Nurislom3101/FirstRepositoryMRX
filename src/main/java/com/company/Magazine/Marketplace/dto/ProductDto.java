package com.company.Magazine.Marketplace.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class ProductDto {

    private Integer product_id;
    private String prod_name;
    private Double received_price;
    private Double selling_price;
    private Double prod_mass;
    private Double prod_amount;
    private int image_id;
    private Timestamp expired_at;
    private Timestamp created_at;
    private Timestamp updated_at;
    private Timestamp deleted_at;
}
