package com.company.Magazine.Marketplace.controller;

import com.company.Magazine.Marketplace.dto.CategoryDto;
import com.company.Magazine.Marketplace.dto.ResponseDto;
import com.company.Magazine.Marketplace.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = ("category"))
public class CategoryController {

    public final CategoryService categoryService;

    @PostMapping(value = ("/create"))
    public ResponseDto<CategoryDto> create(@RequestBody CategoryDto dto) {
        return categoryService.create(dto);
    }

    @GetMapping(value = ("/get/{id}"))
    public ResponseDto<CategoryDto> get(@PathVariable("id") Integer id) {
        return categoryService.get(id);
    }

    @PutMapping(value = ("/update/{id}"))
    public ResponseDto<CategoryDto> update(@RequestBody CategoryDto dto, @PathVariable("id") Integer id) {
        return categoryService.update(dto, id);
    }

    @DeleteMapping(value = ("delete/{id}"))
    public ResponseDto<CategoryDto> delete(@PathVariable("id") Integer id) {
        return categoryService.delete(id);
    }
}
