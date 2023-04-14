package com.validation.data;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Person {

    @NotEmpty(message = "First name cannot empty")
    @Size(min = 2, max = 6, message = "first name length must be 2 - 6")
    private String firstName;

    @NotEmpty(message = "last name cannot empty")
    @Size(min = 2, max = 6, message = "last name length must be 2 - 6")
    private String lastName;

    // @NotNull(message = "address cannot null")
    // @Valid
    // private Address address;

}
