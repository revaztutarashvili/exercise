package com.lecture.mini_drive.mapper;

import com.lecture.mini_drive.model.domain.UserEntity;
import com.lecture.mini_drive.model.dto.UserResponseDto;

public class UserMapper {
    public static UserResponseDto toDto(UserEntity entity){
        return new UserResponseDto(
                entity.getId(),
                entity.getUsername(),
                entity.getEmail(),
                entity.getFirstName()

        );
    }
}
