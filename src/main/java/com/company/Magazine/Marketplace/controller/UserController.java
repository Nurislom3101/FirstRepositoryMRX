package com.company.Magazine.Marketplace.controller;

import com.company.Magazine.Marketplace.dto.ResponseDto;
import com.company.Magazine.Marketplace.dto.UserDto;
import com.company.Magazine.Marketplace.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = ("user"))
public class UserController {

    public final UserService userService;

    @PostMapping(value = ("/create"))
    public ResponseDto<UserDto> create(@RequestBody UserDto dto) {
        return userService.create(dto);
    }

    @GetMapping(value = ("/get/{id}"))
    public ResponseDto<UserDto> get(@PathVariable("id") Integer id) {
        return userService.get(id);
    }

    @PutMapping(value = ("/update/{id}"))
    public ResponseDto<UserDto> update(@RequestBody UserDto dto, @PathVariable("id") Integer id) {
        return userService.update(dto, id);
    }

    @DeleteMapping(value = ("/delete/{id}"))
    public ResponseDto<UserDto> delete(@PathVariable("id") Integer id) {
        return userService.delete(id);
    }
}
