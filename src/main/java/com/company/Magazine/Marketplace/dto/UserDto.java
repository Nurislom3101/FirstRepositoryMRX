package com.company.Magazine.Marketplace.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class UserDto {

    private Integer userId;
    private int loaners_id;
    private int image_id;
    private String user_first_name;
    private String user_last_name;
    private String user_middle_name;
    private String user_name;
    private String user_borrow_name;
    private String user_phone_number;
    private String user_password_series;
    private String user_first_address;
    private String user_second_address;
    private Double user_monthly_price;
    private Timestamp user_birthdate;
    private Timestamp user_working_time;
    private Timestamp user_working_days;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;
}
