package com.realworld.dto.user;

import com.realworld.entity.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DuplicatedEmailValidator implements ConstraintValidator<DuplicatedEmailConstraint, String> {
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return (s == null || s.isEmpty()) || !userRepository.findByEmail(s).isPresent();
    }
}
