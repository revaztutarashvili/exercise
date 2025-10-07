package com.lecture.mini_drive.controller;

import com.lecture.mini_drive.mapper.UserMapper;
import com.lecture.mini_drive.model.domain.UserEntity;
import com.lecture.mini_drive.model.dto.UserResponseDto;
import com.lecture.mini_drive.model.dto.UserSignUpRequestDto;
import com.lecture.mini_drive.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> registerUser(@Valid @RequestBody UserSignUpRequestDto requestDto){
        UserEntity createUser = userService.createUser(requestDto);
        UserResponseDto responseDto = UserMapper.toDto(createUser);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUsersById(@PathVariable Long id) {
        UserEntity foundUser = userService.getUserById(id);
        UserResponseDto responseDto = UserMapper.toDto(foundUser);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id){
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }



}
