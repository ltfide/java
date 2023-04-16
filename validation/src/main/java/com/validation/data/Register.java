package com.validation.data;

import com.validation.data.constraint.CheckPassword;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@CheckPassword(message = "password and retype password must same")
public class Register {

    @NotBlank(message = "username can not blank")
    private String username;

    @NotBlank(message = "password can not blank")
    private String password;

    @NotBlank(message = "retype password can not blank")
    private String retypePassword;

}
