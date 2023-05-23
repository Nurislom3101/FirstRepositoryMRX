package com.company.Magazine.Marketplace.controller;

import com.company.Magazine.Marketplace.dto.BasketDto;
import com.company.Magazine.Marketplace.dto.ResponseDto;
import com.company.Magazine.Marketplace.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = ("basket"))
public class BasketController {

    public final BasketService basketService;

    @PostMapping (value = ("/create"))
    public ResponseDto<BasketDto> create(@RequestBody BasketDto dto) {
        return basketService.create(dto);
    }

    @GetMapping(value = ("/get/{id}"))
    public ResponseDto<BasketDto> get(@PathVariable("id") Integer id) {
        return basketService.get(id);
    }

    @PutMapping(value = ("/update/{id}"))
    public ResponseDto<BasketDto> update(@RequestBody BasketDto dto, @PathVariable("id") Integer id) {
        return basketService.update(dto, id);
    }

    @DeleteMapping(value = ("/delete/{id}"))
    public ResponseDto<BasketDto> delete(@PathVariable("id") Integer id) {
        return basketService.delete(id);
    }
}
