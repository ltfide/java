package com.local;

import lombok.Value;
import lombok.With;

@Value
@With
public class Register {

    private String username;

    private String password;
}
