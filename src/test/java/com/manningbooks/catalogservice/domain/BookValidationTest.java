package com.manningbooks.catalogservice.domain;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BookValidationTest {

    private static Validator validator;

    @BeforeAll
    static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void whenAllFieldsCorrectThenValidationSuccess() {
        var book =  Book.of("1234567890", "JUnit Test", "Luis Suarez", 4.60d);
        Set<ConstraintViolation<Book>> violations = validator.validate(book);
        assertEquals(0, violations.size());
    }

    @Test
    void whenIsbnDefinedButIncorrectThenValidationFails() {
        var book = Book.of("a1234567890", "JUnit Test", "Luis Suarez", 4.60d);
        Set<ConstraintViolation<Book>> violations = validator.validate(book);

        assertAll(
                () -> assertEquals(1, violations.size()),
                () -> assertEquals("The ISBN format must be valid.", violations.iterator().next().getMessage())
                );
    }

}
