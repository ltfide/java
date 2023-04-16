package com.local;

import lombok.*;

@Getter
@NoArgsConstructor(staticName = "createEmpty")
@AllArgsConstructor(staticName = "create")
public class Login {

    @Setter(AccessLevel.PROTECTED)
    private String username;

    @Setter(AccessLevel.PROTECTED)
    private String password;
}
