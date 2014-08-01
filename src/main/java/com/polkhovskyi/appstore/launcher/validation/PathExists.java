package com.polkhovskyi.appstore.launcher.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = PathExistsValidator.class)
public @interface PathExists {
    String message() default "Path does not exist";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
