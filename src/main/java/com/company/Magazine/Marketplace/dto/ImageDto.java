package com.company.Magazine.Marketplace.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class ImageDto {

    private Integer image_id;
    private String image_path;
    private String image_type;
    private int image_size;
    private String image_token;
    private Timestamp created_at;
    private Timestamp updated_at;
    private Timestamp deleted_at;
}
