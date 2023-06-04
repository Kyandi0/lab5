package com.example.lab5;

public interface Validator {
    void validate(Object value);

    //void validate(Object value);

    boolean isValid();
    String getMessage();

}
