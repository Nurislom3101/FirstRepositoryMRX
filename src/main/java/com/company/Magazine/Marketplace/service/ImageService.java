package com.company.Magazine.Marketplace.service;

import com.company.Magazine.Marketplace.dto.ImageDto;
import com.company.Magazine.Marketplace.dto.ResponseDto;
import com.company.Magazine.Marketplace.model.Image;
import com.company.Magazine.Marketplace.repository.ImageRepository;
import com.company.Magazine.Marketplace.service.mapper.ImageMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ImageService {

    private final ImageMapper imageMapper;

    private final ImageRepository imageRepository;
    public ResponseDto<ImageDto> create(ImageDto dto) {
        Image image =imageMapper.toEntity(dto);
        image.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        imageRepository.save(image);
        return ResponseDto.<ImageDto>builder()
                .success(true)
                .massage("Image successfully created!!!")
                .data(imageMapper.toDto(image))
                .build();
    }

    public ResponseDto<ImageDto> get(Integer id) {
        Optional<Image> optional=imageRepository.findByImageIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<ImageDto>builder()
                    .massage("Image details is not found???")
                    .code(-3)
                    .build();
        }
        return ResponseDto.<ImageDto>builder()
                .success(true)
                .massage("Image details is >>")
                .data(imageMapper.toDto(optional.get()))
                .build();
    }

    public ResponseDto<ImageDto> update(ImageDto dto, Integer id) {
        Optional<Image> optional = imageRepository.findByImageIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<ImageDto>builder()
                    .massage("Image details is not found???")
                    .code(-3)
                    .build();
        }
        Image image =imageMapper.toEntity(dto);
        image.setImageId(optional.get().getImageId());
        image.setCreatedAt(optional.get().getCreatedAt());
        image.setDeletedAt(optional.get().getDeletedAt());
        image.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
        imageRepository.save(image);
        return ResponseDto.<ImageDto>builder()
                .success(true)
                .massage("Image successfully updated!!!")
                .data(imageMapper.toDto(image))
                .build();
    }

    public ResponseDto<ImageDto> delete(Integer id) {
        Optional<Image> optional = imageRepository.findByImageIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<ImageDto>builder()
                    .massage("Image details is not found???")
                    .code(-3)
                    .build();
        }

        Image image = optional.get();
        image.setDeletedAt(Timestamp.valueOf(LocalDateTime.now()));
        imageRepository.delete(image);
        imageRepository.save(image);
        return ResponseDto.<ImageDto>builder()
                .success(true)
                .massage("Image successfully deleted!!!")
                .data(imageMapper.toDto(image))
                .build();
    }
}
