package com.company.Magazine.Marketplace.service.mapper;

import com.company.Magazine.Marketplace.dto.UserDto;
import com.company.Magazine.Marketplace.model.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public abstract class UserMapper {
    public abstract User toEntity(UserDto dto) ;

    public abstract UserDto toDto(User user) ;
}
