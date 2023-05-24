package com.company.Magazine.Marketplace.service.mapper;

import com.company.Magazine.Marketplace.dto.ImageDto;
import com.company.Magazine.Marketplace.model.Image;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class ImageMapper {
    public abstract Image toEntity(ImageDto dto);

    public abstract ImageDto toDto(Image image);
}
