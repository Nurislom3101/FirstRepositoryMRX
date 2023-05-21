package com.company.Magazine.Marketplace.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class EmployeesDto {

    private Integer employees_id;
    private int user_id;
    private Timestamp created_at;
    private Timestamp updated_at;
    private Timestamp deleted_at;
}
