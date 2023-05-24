package com.company.Magazine.Marketplace.service;

import com.company.Magazine.Marketplace.dto.BasketDto;
import com.company.Magazine.Marketplace.dto.CategoryDto;
import com.company.Magazine.Marketplace.dto.ResponseDto;
import com.company.Magazine.Marketplace.model.Category;
import com.company.Magazine.Marketplace.repository.CategoryRepository;
import com.company.Magazine.Marketplace.service.mapper.CategoryMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryService {

    private final CategoryMapper categoryMapper;

    private final CategoryRepository categoryRepository;

    public ResponseDto<CategoryDto> create(CategoryDto dto) {
        Category category = categoryMapper.toEntity(dto);
        category.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        categoryRepository.save(category);
        return ResponseDto.<CategoryDto>builder()
                .success(true)
                .massage("Category successfully created")
                .data(categoryMapper.toDto(category))
                .build();
    }

    public ResponseDto<CategoryDto> get(Integer id) {
        Optional<Category> optional = categoryRepository.findByCategoryIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<CategoryDto>builder()
                    .massage("Category is not found")
                    .code(-3)
                    .build();
        }
        return ResponseDto.<CategoryDto>builder()
                .massage("Category details")
                .data(categoryMapper.toDto(optional.get()))
                .build();
    }

    public ResponseDto<CategoryDto> update(CategoryDto dto, Integer id) {
        Optional<Category> optional = categoryRepository.findByCategoryIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<CategoryDto>builder()
                    .massage("Category details is not found")
                    .code(-3)
                    .build();
        }
        Category category = categoryMapper.toEntity(dto);
        category.setCategoryId(optional.get().getCategoryId());
        category.setCreatedAt(optional.get().getCreatedAt());
        category.setDeletedAt(optional.get().getDeletedAt());
        category.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
        categoryRepository.save(category);
        return ResponseDto.<CategoryDto>builder()
                .success(true)
                .massage("Category successfully updated")
                .data(categoryMapper.toDto(category))
                .build();
    }

    public ResponseDto<CategoryDto> delete(Integer id) {
        Optional<Category> optional = categoryRepository.findByCategoryIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<CategoryDto>builder()
                    .massage("Category is not found!!!")
                    .code(-3)
                    .build();
        }
        Category category = optional.get();
        category.setDeletedAt(Timestamp.valueOf(LocalDateTime.now()));
        categoryRepository.delete(category);
        categoryRepository.save(category);
        return ResponseDto.<CategoryDto>builder()
                .massage("Category successful deleted!!!")
                .success(true)
                .data(categoryMapper.toDto(category))
                .build();
    }
}
