package com.example.lab5;

import lombok.RequiredArgsConstructor;

import java.lang.reflect.Field;

@RequiredArgsConstructor
public class RegexValidator implements Validator{
    private Regex regex_validate;
    boolean valid;

    public RegexValidator(Regex annotation) {
        this.regex_validate = annotation;
    }

    @Override
    public void validate(Object value) {
        valid = value.toString().matches(regex_validate.regexPattern());
    }

    @Override
    public boolean isValid() {
        return valid;
    }

    @Override
    public String getMessage() {
        return regex_validate.message();
    }
}
