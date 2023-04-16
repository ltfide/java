package com.validation.data;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@ToString
public class Person {

    private List<@NotBlank(message = "hobby can not blank") String> hobbies;

    @NotEmpty(message = "First name cannot empty")
    @Size(min = 2, max = 6, message = "first name length must be {min} - {max}")
    private String firstName;

    @NotEmpty(message = "last name cannot empty")
    @Size(min = 2, max = 6, message = "last name length must be 2 - 6")
    private String lastName;

    @NotNull(message = "address cannot null")
    @Valid
    private Address address;

    @Valid
    public Person() {

    }

    @Valid
    public Person(
            @NotEmpty(message = "First name cannot empty") String firstName,
            @NotEmpty(message = "last name cannot empty") String lastName,
            @NotNull(message = "address cannot null") @Valid Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public void sayHello(@NotBlank(message = "name must not blank") String name) {
        System.out.println("Hello " + name + ", my name is " + this.firstName);
    }

    @NotBlank(message = "fulname must not blank")
    public String fullName() {
        return this.firstName + " " + this.lastName;
    }

}
