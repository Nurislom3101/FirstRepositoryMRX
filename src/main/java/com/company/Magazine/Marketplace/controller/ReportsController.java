package com.company.Magazine.Marketplace.controller;

import com.company.Magazine.Marketplace.dto.ReportsDto;
import com.company.Magazine.Marketplace.dto.ResponseDto;
import com.company.Magazine.Marketplace.service.ReportsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = ("reports"))
public class ReportsController {

    public final ReportsService reportsService;

    @PostMapping(value = ("/create"))
    public ResponseDto<ReportsDto> create(@RequestBody ReportsDto dto) {
        return reportsService.create(dto);
    }

    @GetMapping(value = ("/get/{id}"))
    public ResponseDto<ReportsDto> get(@PathVariable("id") Integer id) {
        return reportsService.get(id);
    }

    @PutMapping(value = ("/update/{id}"))
    public ResponseDto<ReportsDto> update(@RequestBody ReportsDto dto, @PathVariable("id") Integer id) {
        return reportsService.update(dto, id);
    }

    @DeleteMapping(value = ("/delete/{id}"))
    public ResponseDto<ReportsDto> delete(@PathVariable("id") Integer id) {
        return reportsService.delete(id);
    }

}
