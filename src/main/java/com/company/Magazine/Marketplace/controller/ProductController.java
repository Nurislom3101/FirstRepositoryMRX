package com.company.Magazine.Marketplace.controller;

import com.company.Magazine.Marketplace.dto.ProductDto;
import com.company.Magazine.Marketplace.dto.ResponseDto;
import com.company.Magazine.Marketplace.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = ("product"))
public class ProductController {

    public final ProductService productService;

    @PostMapping(value = ("/create"))
    public ResponseDto<ProductDto> creat(@RequestBody ProductDto dto) {
        return productService.create(dto);
    }

    @GetMapping(value = ("/get/{id}"))
    public ResponseDto<ProductDto> get(@PathVariable("id") Integer id) {
        return productService.get(id);
    }

    @PutMapping(value = ("/update/{id}"))
    public ResponseDto<ProductDto> update(@RequestBody ProductDto dto, @PathVariable Integer id) {
        return productService.update(dto, id);
    }

    @DeleteMapping(value = ("/delete/{id}"))
    public ResponseDto<ProductDto> delete(@PathVariable Integer id) {
        return productService.delete(id);
    }
}
