package com.lecture.mini_drive.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserSignUpRequestDto {
    @NotBlank(message = "username cannot be blank")
    private String username;

    @NotBlank(message = "field cannot be blank")
    @Size(min = 6, max = 16, message = "password should be 6-16 symbols")
    private String Password;

    @NotBlank(message = "field cannot be blank")
    @Email(message = "please provide valid email address")
    private String email;


    private String firstname;


}
