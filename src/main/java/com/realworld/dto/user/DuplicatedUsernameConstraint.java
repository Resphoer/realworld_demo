package com.realworld.dto.user;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DuplicatedUsernameValidator.class)

public @interface DuplicatedUsernameConstraint {
    String message() default "duplicated username";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
