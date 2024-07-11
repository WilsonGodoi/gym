package com.will.gym.services.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateUserDTO {
    @NotNull(message = "Name can't be null")
    private String firstName;
    private String lastName;
    @Email(message = "Email format")
    private String email;
    @NotNull(message = "Password can't be null")
    @Size(min = 8, message = "Password with min 8 chars is required")
    private String password;
    private String confirmationPassword;
}
