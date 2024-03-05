package edu.hw4;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class AnimalValidator {
    private AnimalValidator() {

    }

    public static Set<ValidationError> getErrors(Animal animal) {
        Set<ValidationError> errors = new HashSet<>();
        if (animal.age() < 0) {
            errors.add(new ValidationError("Invalid age"));
        }
        if (animal.weight() < 0) {
            errors.add(new ValidationError("Invalid weight"));
        }
        if (animal.height() < 0) {
            errors.add(new ValidationError("Invalid height"));
        }
        if (!Pattern.compile("^[a-zA-Z0-9 ]*$").matcher(animal.name()).matches()) {
            errors.add(new ValidationError("Invalid name"));
        }
        return errors;
    }

    public record ValidationError(String error) {
    }
}
