package com.company.Magazine.Marketplace.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class LoanerDto {

    private Integer loaner_id;
    private int basked_id;
    private Double total_price;
    private Boolean loaner_status;
    private Timestamp created_at;
    private Timestamp updated_at;
    private Timestamp deleted_at;
}
