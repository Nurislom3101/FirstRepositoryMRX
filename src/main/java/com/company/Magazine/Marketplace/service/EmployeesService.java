package com.company.Magazine.Marketplace.service;

import com.company.Magazine.Marketplace.dto.EmployeesDto;
import com.company.Magazine.Marketplace.dto.ResponseDto;
import com.company.Magazine.Marketplace.model.Employees;
import com.company.Magazine.Marketplace.repository.EmployeesRepository;
import com.company.Magazine.Marketplace.service.mapper.EmployeesMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeesService {

    private final EmployeesMapper employeesMapper;

    private final EmployeesRepository employeesRepository;

    public ResponseDto<EmployeesDto> create(EmployeesDto dto) {
        Employees employees = employeesMapper.toEntity(dto);
        employees.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        return ResponseDto.<EmployeesDto>builder()
                .success(true)
                .massage("Employees successful created!!!")
                .data(employeesMapper.toDto(employees))
                .build();
    }

    public ResponseDto<EmployeesDto> get(Integer id) {
        Optional<Employees> optional = employeesRepository.findByEmployeesIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<EmployeesDto>builder()
                    .massage("Employees is not found???")
                    .code(-3)
                    .build();
        }
        return ResponseDto.<EmployeesDto>builder()
                .massage("Employees details is >")
                .data(employeesMapper.toDto(optional.get()))
                .build();
    }

    public ResponseDto<EmployeesDto> update(EmployeesDto dto, Integer id) {
        Optional<Employees> optional = employeesRepository.findByEmployeesIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<EmployeesDto>builder()
                    .massage("Employees details is not found???")
                    .code(-3)
                    .build();
        }
        Employees employees = employeesMapper.toEntity(dto);
        employees.setEmployeesId(optional.get().getEmployeesId());
        employees.setCreatedAt(optional.get().getCreatedAt());
        employees.setDeletedAt(optional.get().getDeletedAt());
        employees.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
        employeesRepository.save(employees);
        return ResponseDto.<EmployeesDto>builder()
                .success(true)
                .massage("Employees successfully updated!!!")
                .data(employeesMapper.toDto(employees))
                .build();
    }

    public ResponseDto<EmployeesDto> delete(Integer id) {
        Optional<Employees> optional = employeesRepository.findByEmployeesIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<EmployeesDto>builder()
                    .massage("Employees details is not found")
                    .build();
        }
        Employees employees = optional.get();
        employees.setDeletedAt(Timestamp.valueOf(LocalDateTime.now()));
        employeesRepository.save(employees);
        return ResponseDto.<EmployeesDto>builder()
                .success(true)
                .massage("Employees successfully deleted!!!")
                .data(employeesMapper.toDto(employees))
                .build();
    }
}
