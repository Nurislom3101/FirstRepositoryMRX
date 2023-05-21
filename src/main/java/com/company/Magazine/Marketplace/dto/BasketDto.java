package com.company.Magazine.Marketplace.dto;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class BasketDto {

    private Integer basket_id;
    private int product_id;
    private Double prod_mass;
    private Double prod_price;
    private Double total_price;
    private Timestamp created_at;
    private Timestamp updated_at;
    private Timestamp deleted_at;
}
