package com.example.photo.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Запрос на регистрацию")
public class SignUpRequest {

    @Size(min = 5, max = 50)
    @NotNull
    private String username;

    @Size(min = 5, max = 255)
    @NotNull
    @Email(message = "Email адрес должен быть в формате user@example.com")
    private String email;

    @Size(max = 255, message = "Длина пароля должна быть не более 255 символов")
    private String password;
}