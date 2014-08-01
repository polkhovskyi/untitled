package com.polkhovskyi.appstore.launcher.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.io.File;

public class PathIsDirectoryValidator implements ConstraintValidator<PathIsDirectory, File> {
    @Override
    public void initialize(PathIsDirectory constraintAnnotation) {
    }

    @Override
    public boolean isValid(File value, ConstraintValidatorContext context) {
        if(value == null) {
            return true;
        }

        if(!value.exists()) {
            return true;
        }

        return value.isDirectory();
    }
}
