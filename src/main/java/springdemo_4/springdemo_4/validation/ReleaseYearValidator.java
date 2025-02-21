package springdemo_4.springdemo_4.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.Year;

public class ReleaseYearValidator implements ConstraintValidator<ValidReleaseYear, Integer> {
    private static final int MIN_YEAR = 1900;

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        int currentYear = Year.now().getValue();
        return value >= MIN_YEAR && value <= currentYear;
    }
}
