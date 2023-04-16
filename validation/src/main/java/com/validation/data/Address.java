package com.validation.data;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @NotBlank(message = "street cannot blank")
    private String street;

    @NotBlank(message = "city cannot blank")
    private String city;

    @NotBlank(message = "country cannot blank")
    private String country;

}
