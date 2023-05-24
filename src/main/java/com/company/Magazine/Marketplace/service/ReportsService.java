package com.company.Magazine.Marketplace.service;

import com.company.Magazine.Marketplace.dto.ReportsDto;
import com.company.Magazine.Marketplace.dto.ResponseDto;
import com.company.Magazine.Marketplace.model.Reports;
import com.company.Magazine.Marketplace.repository.ReportsRepository;
import com.company.Magazine.Marketplace.service.mapper.ReportsMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReportsService {
    private final ReportsMapper reportsMapper;

    private final ReportsRepository reportsRepository;

    public ResponseDto<ReportsDto> create(ReportsDto dto) {
        Reports reports = reportsMapper.toEntity(dto);
        reports.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        reportsRepository.save(reports);
        return ResponseDto.<ReportsDto>builder()
                .success(true)
                .massage("Reports successfully created!!!")
                .data(reportsMapper.toDto(reports))
                .build();
    }

    public ResponseDto<ReportsDto> get(Integer id) {
        Optional<Reports> optional = reportsRepository.findByReportsIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<ReportsDto>builder()
                    .massage("Reports details is not found???")
                    .code(-3)
                    .build();
        }
        return ResponseDto.<ReportsDto>builder()
                .success(true)
                .massage("Reports details is>>>")
                .data(reportsMapper.toDto(optional.get()))
                .build();
    }

    public ResponseDto<ReportsDto> update(ReportsDto dto, Integer id) {
        Optional<Reports> optional = reportsRepository.findByReportsIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<ReportsDto>builder()
                    .massage("Reports details is not found???")
                    .code(-3)
                    .build();
        }
        Reports reports = reportsMapper.toEntity(dto);
        reports.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
        reportsRepository.save(reports);
        return ResponseDto.<ReportsDto>builder()
                .success(true)
                .massage("Reports successfully updated!!!")
                .data(reportsMapper.toDto(reports))
                .build();
    }

    public ResponseDto<ReportsDto> delete(Integer id) {
        Optional<Reports> optional = reportsRepository.findByReportsIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<ReportsDto>builder()
                    .massage("Reports details is not found???")
                    .code(-3)
                    .build();
        }
        Reports reports = optional.get();
        reports.setDeletedAt(Timestamp.valueOf(LocalDateTime.now()));
        reportsRepository.delete(reports);
        reportsRepository.save(reports);
        return ResponseDto.<ReportsDto>builder()
                .massage("Reports successfully deleted!!!")
                .success(true)
                .data(reportsMapper.toDto(reports))
                .build();
    }
}
