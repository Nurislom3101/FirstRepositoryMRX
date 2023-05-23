package com.company.Magazine.Marketplace.service.mapper;

import com.company.Magazine.Marketplace.dto.BasketDto;
import com.company.Magazine.Marketplace.model.Basket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public abstract class BasketMapper {

    
    public abstract Basket toEntity(BasketDto dto);

    public abstract BasketDto toDto(Basket basket);
}
