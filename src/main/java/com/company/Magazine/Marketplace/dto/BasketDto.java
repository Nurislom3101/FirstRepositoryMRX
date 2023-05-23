package com.company.Magazine.Marketplace.dto;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class BasketDto {

    private Integer basketId;
    private int product_id;
    private Double prod_mass;
    private Double prod_price;
    private Double total_price;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;


}
