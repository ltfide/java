package com.validation.data;

import com.validation.data.container.Data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SampleData {

    @NotNull
    private Data<@NotBlank @Size(min = 10) String> data;
}
