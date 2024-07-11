package com.will.gym.services.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserCreatedDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
