package com.realworld.dto.user;

import com.realworld.entity.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DuplicatedUsernameValidator implements ConstraintValidator<DuplicatedUsernameConstraint, String> {
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return (value == null || value.isEmpty()) || !userRepository.findByUsername(value).isPresent();
    }
}
