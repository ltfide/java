package com.validation.data;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {

    @NotBlank(message = "street cannot blank")
    private String street;

    @NotBlank(message = "city cannot blank")
    private String city;

    @NotBlank(message = "country cannot blank")
    private String country;

}
