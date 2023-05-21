package com.company.Magazine.Marketplace.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class ForeignDto {

    private Integer foreign_id;
    private String foreign_company_name;
    private String foreign_fullName;
    private String foreign_first_phone_number;
    private String foreign_second_phone_number;
    private Boolean foreign_status;
    private Timestamp created_at;
    private Timestamp updated_at;
    private Timestamp deleted_at;
}
