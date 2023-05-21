package com.company.Magazine.Marketplace.controller;

import com.company.Magazine.Marketplace.dto.ForeignDto;
import com.company.Magazine.Marketplace.dto.ResponseDto;
import com.company.Magazine.Marketplace.service.ForeignService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = ("foreign"))
public class ForeignController {

    public final ForeignService foreignService;

    @PostMapping(value = ("/create"))
    public ResponseDto<ForeignDto> create(@RequestBody ForeignDto dto) {
        return foreignService.create(dto);
    }

    @GetMapping(value = ("/get/{id}"))
    public ResponseDto<ForeignDto> get(@PathVariable("id") Integer id) {
        return foreignService.get(id);
    }

    @PutMapping(value = ("/update/{id}"))
    public ResponseDto<ForeignDto> update(@RequestBody ForeignDto dto, @PathVariable("id") Integer id) {
        return foreignService.update(dto, id);
    }

    @DeleteMapping(value = ("/delete/{id}"))
    public ResponseDto<ForeignDto> delete(@PathVariable("id") Integer id) {
        return foreignService.delete(id);
    }
}
