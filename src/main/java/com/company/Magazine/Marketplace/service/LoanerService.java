package com.company.Magazine.Marketplace.service;

import com.company.Magazine.Marketplace.dto.LoanerDto;
import com.company.Magazine.Marketplace.dto.ResponseDto;
import com.company.Magazine.Marketplace.model.Loaner;
import com.company.Magazine.Marketplace.repository.LoanerRepository;
import com.company.Magazine.Marketplace.service.mapper.LoanerMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoanerService {

    private final LoanerMapper loanerMapper;

    private final LoanerRepository loanerRepository;
    public ResponseDto<LoanerDto> create(LoanerDto dto) {
        Loaner loaner = loanerMapper.toEntity(dto);
        loaner.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        loanerRepository.save(loaner);
        return ResponseDto.<LoanerDto>builder()
                .success(true)
                .massage("Loaner successfully created!!!")
                .data(loanerMapper.toDto(loaner))
                .build();
    }

    public ResponseDto<LoanerDto> get(Integer id) {
        Optional<Loaner> optional = loanerRepository.findByLoanerIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<LoanerDto>builder()
                    .massage("Loaner details is not found")
                    .code(-3)
                    .build();
        }
        return ResponseDto.<LoanerDto>builder()
                .success(true)
                .massage("Loaner details is >>")
                .data(loanerMapper.toDto(optional.get()))
                .build();
    }

    public ResponseDto<LoanerDto> update(LoanerDto dto, Integer id) {
        Optional<Loaner> optional =loanerRepository.findByLoanerIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<LoanerDto>builder()
                    .massage("Loaner details is not found???")
                    .code(-3)
                    .build();
        }
        Loaner loaner = loanerMapper.toEntity(dto);
        loaner.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
        loanerRepository.save(loaner);
        return ResponseDto.<LoanerDto>builder()
                .success(true)
                .massage("Loaner successfully updated!!!")
                .data(loanerMapper.toDto(loaner))
                .build();
    }

    public ResponseDto<LoanerDto> delete(Integer id) {
        Optional<Loaner> optional = loanerRepository.findByLoanerIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<LoanerDto>builder()
                    .massage("Loaner details is not found")
                    .code(-3)
                    .build();
        }
        Loaner loaner = optional.get();
        loaner.setDeletedAt(Timestamp.valueOf(LocalDateTime.now()));
        loanerRepository.delete(loaner);
        loanerRepository.save(loaner);
        return ResponseDto.<LoanerDto>builder()
                .success(true)
                .massage("Loaner successfully deleted!!!")
                .data(loanerMapper.toDto(loaner))
                .build();
    }
}
