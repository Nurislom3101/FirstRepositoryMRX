package com.company.Magazine.Marketplace.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class CategoryDto {

    private Integer categoryId;
    private int product_id;
    private String category_name;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;
}
