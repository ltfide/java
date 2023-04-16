package com.local;

import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private String name;

    private Integer age;

    @Singular
    private List<String> hobbies;
}
