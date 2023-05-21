package com.company.Magazine.Marketplace.controller;

import com.company.Magazine.Marketplace.dto.ImageDto;
import com.company.Magazine.Marketplace.dto.ResponseDto;
import com.company.Magazine.Marketplace.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = ("image"))
public class ImageController {

    public final ImageService imageService;

    @PostMapping(value = ("/create"))
    public ResponseDto<ImageDto> create(@RequestBody ImageDto dto) {
        return imageService.create(dto);
    }

    @GetMapping(value = ("/get/{id}"))
    public ResponseDto<ImageDto> get(@PathVariable("id") Integer id) {
        return imageService.get(id);
    }

    @PutMapping(value = ("/update/{id}"))
    public ResponseDto<ImageDto> update(@RequestBody ImageDto dto, @PathVariable("id") Integer id) {
        return imageService.update(dto, id);
    }

    @DeleteMapping(value = ("/delete/{id}"))
    public ResponseDto<ImageDto> delete(@PathVariable("id") Integer id) {
        return imageService.delete(id);
    }

}
