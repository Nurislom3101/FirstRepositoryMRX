package com.company.Magazine.Marketplace.service.mapper;

import com.company.Magazine.Marketplace.dto.ForeignDto;
import com.company.Magazine.Marketplace.model.Foreign;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class ForeignMapper {

    public abstract Foreign toEntity(ForeignDto dto);

    public abstract ForeignDto toDto(Foreign foreign);
}
