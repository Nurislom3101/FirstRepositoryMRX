package com.company.Magazine.Marketplace.service.mapper;

import com.company.Magazine.Marketplace.dto.ReportsDto;
import com.company.Magazine.Marketplace.model.Reports;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public abstract class ReportsMapper {
    public abstract Reports toEntity(ReportsDto dto);

    public abstract ReportsDto toDto(Reports reports);
}
