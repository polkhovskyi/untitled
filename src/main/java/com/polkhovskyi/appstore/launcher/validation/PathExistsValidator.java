package com.polkhovskyi.appstore.launcher.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.io.File;

public class PathExistsValidator implements ConstraintValidator<PathExists, File> {
    @Override
    public void initialize(PathExists constraintAnnotation) {
    }

    @Override
    public boolean isValid(File value, ConstraintValidatorContext context) {
        if(value == null) {
            return true;
        }
        return value.exists();
    }
}
