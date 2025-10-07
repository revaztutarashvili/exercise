package com.lecture.mini_drive.service;

import com.lecture.mini_drive.model.domain.UserEntity;
import com.lecture.mini_drive.model.dto.UserSignUpRequestDto;
import com.lecture.mini_drive.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    @Transactional
    public UserEntity createUser(UserSignUpRequestDto requestDto){
        log.info("going to create user ");

        Optional<UserEntity> existingUser = userRepository.findByUsername(requestDto.getUsername());
        if (existingUser.isPresent()){
            log.error("user with username '{}' already exist", requestDto.getUsername());
            throw new RuntimeException("user with username " + requestDto.getUsername() + " already exist");

        }

        UserEntity newUser = new UserEntity();
        newUser.setUsername(requestDto.getUsername());
        newUser.setEmail(requestDto.getEmail());
        newUser.setFirstName(requestDto.getFirstname());
        // TODO: პაროლის დაშიფვრა მაქვს გასაკეთეებელი!
        newUser.setPassword(requestDto.getPassword());

        log.info("user account created successfully ");
        return userRepository.save(newUser);

    }

    public UserEntity getUserById(Long id){
        log.info("going to find user by id: {}", id);
        return userRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("user with id: " + id + "not found"));

    }

public void deleteUserById(Long id){
        log.info("going to delete user by id: {}", id);
        userRepository.findById(id).
                orElseThrow(()-> new RuntimeException("user by id:  " + id + " not found"));

        userRepository.deleteById(id);
    log.info("deleted user by id: {}", id);
}


}
