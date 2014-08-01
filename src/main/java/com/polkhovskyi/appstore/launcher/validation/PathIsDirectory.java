package com.polkhovskyi.appstore.launcher.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = PathIsDirectoryValidator.class)
public @interface PathIsDirectory {
    String message() default "Path is not a folder";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
