package com.validation.data;

import com.validation.data.container.Entry;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SampleEntry {

    @NotNull
    private Entry<@NotBlank String, @NotBlank String> entry;
}
