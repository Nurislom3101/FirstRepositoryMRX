package com.company.Magazine.Marketplace.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class CategoryDto {

    private Integer category_id;
    private int product_id;
    private String category_name;
    private Timestamp created_at;
    private Timestamp updated_at;
    private Timestamp deleted_at;
}
