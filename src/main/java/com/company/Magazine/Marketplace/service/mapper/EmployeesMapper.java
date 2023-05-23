package com.company.Magazine.Marketplace.service.mapper;

import com.company.Magazine.Marketplace.dto.EmployeesDto;
import com.company.Magazine.Marketplace.model.Employees;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class EmployeesMapper {

    public abstract Employees toEntity(EmployeesDto dto);

    public abstract EmployeesDto toDto(Employees employees);
}
