package com.company.Magazine.Marketplace.controller;

import com.company.Magazine.Marketplace.dto.LoanerDto;
import com.company.Magazine.Marketplace.dto.ResponseDto;
import com.company.Magazine.Marketplace.service.LoanerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = ("loaner"))
public class LoanerController {

    public final LoanerService loanerService;

    @PostMapping(value = ("/create"))
    public ResponseDto<LoanerDto> create(@RequestBody LoanerDto dto) {
        return loanerService.create(dto);
    }

    @GetMapping(value = "/get/{id}")
    public ResponseDto<LoanerDto> get(@PathVariable("id") Integer id) {
        return loanerService.get(id);
    }

    @PutMapping(value = ("/update/{id}"))
    public ResponseDto<LoanerDto> update(@RequestBody LoanerDto dto, @PathVariable("id") Integer id) {
        return loanerService.update(dto, id);
    }

    @DeleteMapping(value = ("/delete/{id}"))
    public ResponseDto<LoanerDto> delete(@PathVariable("id") Integer id) {
        return loanerService.delete(id);
    }
}
