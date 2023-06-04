package com.example.lab5;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
    @Regex(regexPattern = ".*a$", message = "Wpisane imie nie jest damskie")
    private String name;
}
