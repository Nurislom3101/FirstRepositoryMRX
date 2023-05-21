package com.company.Magazine.Marketplace.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ResponseDto<T> {
        private boolean success;

        private String massage;

        /*
         * 0  - Ok
         * -1 - database error
         *-2  - validation error
         *-3  - not found
         * */


        private int code;

        private T data;

        private List<ErrorDto> errors;
}
