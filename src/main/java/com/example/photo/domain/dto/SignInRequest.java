package com.example.photo.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
@Schema(description = "Запрос на аутентификацию")
public class SignInRequest {

    @NotNull
    private String username;

    @NotNull
    private String password;
}