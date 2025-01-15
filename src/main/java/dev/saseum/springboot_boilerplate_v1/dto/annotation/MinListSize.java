package dev.saseum.springboot_boilerplate_v1.dto.annotation;

import dev.saseum.springboot_boilerplate_v1.dto.validator.MinListSizeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MinListSizeValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MinListSize {
    String message() default "The list must be a minimum size";

    long min() default -1L;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
