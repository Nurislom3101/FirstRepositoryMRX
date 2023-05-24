package com.company.Magazine.Marketplace.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class ForeignDto {

    private Integer foreignId;
    private String foreign_company_name;
    private String foreign_fullName;
    private String foreign_first_phone_number;
    private String foreign_second_phone_number;
    private Boolean foreign_status;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;
}
