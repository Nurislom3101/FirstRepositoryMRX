package com.company.Magazine.Marketplace.service.mapper;

import com.company.Magazine.Marketplace.dto.CategoryDto;
import com.company.Magazine.Marketplace.model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class CategoryMapper {
    public abstract Category toEntity(CategoryDto dto);

    public abstract CategoryDto toDto(Category category);
}
