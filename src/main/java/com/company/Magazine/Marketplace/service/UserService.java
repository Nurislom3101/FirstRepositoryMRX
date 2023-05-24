package com.company.Magazine.Marketplace.service;

import com.company.Magazine.Marketplace.dto.ResponseDto;
import com.company.Magazine.Marketplace.dto.UserDto;
import com.company.Magazine.Marketplace.model.User;
import com.company.Magazine.Marketplace.repository.UserRepository;
import com.company.Magazine.Marketplace.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserMapper userMapper;

    private final UserRepository userRepository;

    public ResponseDto<UserDto> create(UserDto dto) {
        User user = userMapper.toEntity(dto);
        user.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        userRepository.save(user);
        return ResponseDto.<UserDto>builder()
                .success(true)
                .massage("User successfully created!!!")
                .data(userMapper.toDto(user))
                .build();
    }

    public ResponseDto<UserDto> get(Integer id) {
        Optional<User> optional = userRepository.findByUserIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<UserDto>builder()
                    .massage("User details is not found??")
                    .code(-3)
                    .build();
        }
        return ResponseDto.<UserDto>builder()
                .success(true)
                .massage("User details is >>")
                .data(userMapper.toDto(optional.get()))
                .build();
    }

    public ResponseDto<UserDto> update(UserDto dto, Integer id) {
        Optional<User> optional = userRepository.findByUserIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<UserDto>builder()
                    .massage("User details is not found???")
                    .code(-3)
                    .build();
        }
        User user = userMapper.toEntity(dto);
        user.setUserId(optional.get().getUserId());
        user.setCreatedAt(optional.get().getCreatedAt());
        user.setDeletedAt(optional.get().getDeletedAt());
        user.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
        userRepository.save(user);
        return ResponseDto.<UserDto>builder()
                .success(true)
                .massage("User successfully updated!!!")
                .data(userMapper.toDto(user))
                .build();
    }

    public ResponseDto<UserDto> delete(Integer id) {
        Optional<User> optional = userRepository.findByUserIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<UserDto>builder()
                    .massage("User details is not found???")
                    .code(-3)
                    .build();
        }
        User user = optional.get();
        user.setDeletedAt(Timestamp.valueOf(LocalDateTime.now()));
        userRepository.delete(user);
        userRepository.save(user);
        return ResponseDto.<UserDto>builder()
                .success(true)
                .massage("User successfully deleted!!!")
                .data(userMapper.toDto(user))
                .build();
    }
}
