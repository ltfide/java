package com.validation.data;

import com.validation.data.container.DataInteger;

import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SampleDataInteger {

    @Min(value = 10)
    private DataInteger data;
}
