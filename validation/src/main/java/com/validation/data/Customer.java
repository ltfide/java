package com.validation.data;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @NotBlank(message = "name must not blank")
    private String name;

    @NotBlank(message = "email must not blank")
    @Email(message = "email must valid format")
    private String email;
}
