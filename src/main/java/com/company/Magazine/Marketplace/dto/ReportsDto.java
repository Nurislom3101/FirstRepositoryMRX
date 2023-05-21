package com.company.Magazine.Marketplace.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class ReportsDto{

    private Integer reports_id;
    private int category_id;
    private String prodName;
    private Double prod_present;
    private Timestamp created_at;
    private Timestamp updated_at;
    private Timestamp deleted_at;
}
