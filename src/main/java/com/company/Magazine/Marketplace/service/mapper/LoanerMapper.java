package com.company.Magazine.Marketplace.service.mapper;

import com.company.Magazine.Marketplace.dto.LoanerDto;
import com.company.Magazine.Marketplace.model.Loaner;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public abstract class LoanerMapper {
    public abstract Loaner toEntity(LoanerDto dto);

    public abstract LoanerDto toDto(Loaner loaner);
}
