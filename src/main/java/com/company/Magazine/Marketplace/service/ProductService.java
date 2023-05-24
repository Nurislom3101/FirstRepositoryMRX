package com.company.Magazine.Marketplace.service;

import com.company.Magazine.Marketplace.dto.ProductDto;
import com.company.Magazine.Marketplace.dto.ResponseDto;
import com.company.Magazine.Marketplace.model.Product;
import com.company.Magazine.Marketplace.repository.ProductRepository;
import com.company.Magazine.Marketplace.service.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductMapper productMapper;

    private final ProductRepository productRepository;

    public ResponseDto<ProductDto> create(ProductDto dto) {
        Product product = productMapper.toEntity(dto);
        product.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        productRepository.save(product);
        return ResponseDto.<ProductDto>builder()
                .success(true)
                .massage("Product successfully created!!!")
                .data(productMapper.toDto(product))
                .build();
    }

    public ResponseDto<ProductDto> get(Integer id) {
        Optional<Product> optional = productRepository.findByProductIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<ProductDto>builder()
                    .massage("Product details is not found???")
                    .code(-3)
                    .build();
        }
        return ResponseDto.<ProductDto>builder()
                .success(true)
                .massage("Product details is >> ")
                .data(productMapper.toDto(optional.get()))
                .build();
    }

    public ResponseDto<ProductDto> update(ProductDto dto, Integer id) {
        Optional<Product> optional = productRepository.findByProductIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<ProductDto>builder()
                    .massage("Product details is not found???")
                    .code(-3)
                    .build();
        }
        Product product = productMapper.toEntity(dto);
        product.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
        productRepository.save(product);
        return ResponseDto.<ProductDto>builder()
                .success(true)
                .massage("Product successfully updated!!!")
                .data(productMapper.toDto(product))
                .build();
    }

    public ResponseDto<ProductDto> delete(Integer id) {
        Optional<Product> optional = productRepository.findByProductIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<ProductDto>builder()
                    .massage("Product details is not found???")
                    .code(-3)
                    .build();
        }
        Product product = optional.get();
        product.setDeletedAt(Timestamp.valueOf(LocalDateTime.now()));
        productRepository.delete(product);
        productRepository.save(product);
        return ResponseDto.<ProductDto>builder()
                .success(true)
                .massage("Product successfully deleted!!!")
                .data(productMapper.toDto(product))
                .build();
    }
}
