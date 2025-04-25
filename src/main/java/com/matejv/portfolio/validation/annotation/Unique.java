package com.matejv.portfolio.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import com.matejv.portfolio.validation.validator.UniqueValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueValidator.class)
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Unique {
  String message() default "Value must be unique";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  String fieldName();

  Class<?> entityClass();
}
