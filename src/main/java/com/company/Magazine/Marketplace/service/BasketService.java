package com.company.Magazine.Marketplace.service;

import com.company.Magazine.Marketplace.dto.BasketDto;
import com.company.Magazine.Marketplace.dto.ResponseDto;
import com.company.Magazine.Marketplace.model.Basket;
import com.company.Magazine.Marketplace.repository.BasketRepository;
import com.company.Magazine.Marketplace.service.mapper.BasketMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BasketService {


    private final BasketMapper basketMapper;

    private final BasketRepository basketRepository;

    public ResponseDto<BasketDto> create(BasketDto dto) {
        Basket basket = basketMapper.toEntity(dto);
       // basket.setCreated_at(LocalDateTime.now());
        basketRepository.save(basket);
        return ResponseDto.<BasketDto>builder()
                .success(true)
                .massage("Basket successful created")
                .data(basketMapper.toDto(basket))
                .build();
    }

    public ResponseDto<BasketDto> get(Integer id) {
        Optional<Basket> optional=basketRepository.findByBasketIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<BasketDto>builder()
                    .massage("Basket details not found?")
                    .code(-3)
                    .build();
        }
        return ResponseDto.<BasketDto>builder()
                .massage("Basket details: ")
                .data(basketMapper.toDto(optional.get()))
                .build();
    }

    public ResponseDto<BasketDto> update(BasketDto dto, Integer id) {
        Optional<Basket> optional = basketRepository.findByBasketIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<BasketDto>builder()
                    .massage("Basket details not found?")
                    .code(-3)
                    .build();
        }
       Basket basket = basketMapper.toEntity(dto);
        basket.setBasketId(optional.get().getBasketId());
        basket.setCreatedAt(optional.get().getCreatedAt());
        basket.setDeletedAt(optional.get().getDeletedAt());
        basket.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
        basketRepository.save(basket);
        return ResponseDto.<BasketDto>builder()
                .success(true)
                .massage("Basket successful updated")
                .data(basketMapper.toDto(basket))
                .build();
    }
    public ResponseDto<BasketDto> delete(Integer id) {
        Optional<Basket> optional = basketRepository.findByBasketIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<BasketDto>builder()
                    .massage("Basket details not found?")
                    .code(-3)
                    .build();
        }
        Basket basket = optional.get();
        basketRepository.delete(basket);
        basketRepository.save(basket);
        return ResponseDto.<BasketDto>builder()
                .massage("Basket successful deleted!!!")
                .success(true)
                .data(basketMapper.toDto(basket))
                .build();
    }
}


