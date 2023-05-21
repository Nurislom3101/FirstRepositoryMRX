package com.company.Magazine.Marketplace.controller;

import com.company.Magazine.Marketplace.dto.EmployeesDto;
import com.company.Magazine.Marketplace.dto.ResponseDto;
import com.company.Magazine.Marketplace.service.EmployeesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = ("employees"))
public class EmployeesController {

    public final EmployeesService employeesService;

    @PostMapping(value = ("/create"))
    public ResponseDto<EmployeesDto> create(@RequestBody EmployeesDto dto) {
        return employeesService.create(dto);
    }

    @GetMapping(value = ("/get/{id}"))
    public ResponseDto<EmployeesDto> get(@PathVariable("id") Integer id) {
        return employeesService.get(id);
    }

    @PutMapping(value = ("/update/{id}"))
    public ResponseDto<EmployeesDto> update(@RequestBody EmployeesDto dto, @PathVariable("id") Integer id) {
        return employeesService.update(dto, id);
    }

    @DeleteMapping(value = ("/delete/{id}"))
    public ResponseDto<EmployeesDto> delete(@PathVariable("id") Integer id) {
        return employeesService.delete(id);
    }
}
