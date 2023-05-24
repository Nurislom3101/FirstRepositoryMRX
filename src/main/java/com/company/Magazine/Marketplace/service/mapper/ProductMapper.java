package com.company.Magazine.Marketplace.service.mapper;

import com.company.Magazine.Marketplace.dto.ProductDto;
import com.company.Magazine.Marketplace.model.Product;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public abstract class ProductMapper {
    public abstract Product toEntity(ProductDto dto);

    public abstract ProductDto toDto(Product product);
}
