package com.company.Magazine.Marketplace.service;

import com.company.Magazine.Marketplace.dto.ForeignDto;
import com.company.Magazine.Marketplace.dto.ResponseDto;
import com.company.Magazine.Marketplace.model.Foreign;
import com.company.Magazine.Marketplace.repository.ForeignRepository;
import com.company.Magazine.Marketplace.service.mapper.ForeignMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ForeignService {

    private final ForeignMapper foreignMapper;

    private final ForeignRepository foreignRepository;

    public ResponseDto<ForeignDto> create(ForeignDto dto) {
        Foreign foreign = foreignMapper.toEntity(dto);
        foreign.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        foreignRepository.save(foreign);
        return ResponseDto.<ForeignDto>builder()
                .success(true)
                .massage("Foreign successfully created!!!")
                .data(foreignMapper.toDto(foreign))
                .build();
    }

    public ResponseDto<ForeignDto> get(Integer id) {
        Optional<Foreign> optional = foreignRepository.findByForeignIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<ForeignDto>builder()
                    .massage("Foreign is not found???")
                    .code(-3)
                    .build();
        }
        return ResponseDto.<ForeignDto>builder()
                .success(true)
                .massage("Foreign details is >> ")
                .data(foreignMapper.toDto(optional.get()))
                .build();
    }

    public ResponseDto<ForeignDto> update(ForeignDto dto, Integer id) {
        Optional<Foreign> optional = foreignRepository.findByForeignIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<ForeignDto>builder()
                    .massage("Foreign is not found???")
                    .code(-3)
                    .build();
        }
        Foreign foreign = foreignMapper.toEntity(dto);
        foreign.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
        foreignRepository.save(foreign);
        return ResponseDto.<ForeignDto>builder()
                .success(true)
                .massage("Foreign successfully updated!!!")
                .data(foreignMapper.toDto(foreign))
                .build();
    }

    public ResponseDto<ForeignDto> delete(Integer id) {
        Optional<Foreign> optional = foreignRepository.findByForeignIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<ForeignDto>builder()
                    .massage("Foreign details is not found???")
                    .code(-3)
                    .build();
        }
        Foreign foreign = optional.get();
        foreign.setDeletedAt(Timestamp.valueOf(LocalDateTime.now()));
        foreignRepository.delete(foreign);
        foreignRepository.save(foreign);
        return ResponseDto.<ForeignDto>builder()
                .success(true)
                .massage("Foreign successfully deleted!!!")
                .data(foreignMapper.toDto(foreign))
                .build();
    }
}
