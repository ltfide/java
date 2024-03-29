package com.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.executable.ExecutableValidator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.validation.data.extractor.DataIntegerValueExtractor;
import com.validation.data.extractor.DataValueExtractor;
import com.validation.data.extractor.EntryValueExtractorKey;
import com.validation.data.extractor.EntryValueExtractorValue;

import java.util.Set;

public abstract class AbstractValidatorTest {

    private ValidatorFactory validatorFactory;

    protected Validator validator;

    protected ExecutableValidator executableValidator;

    @BeforeEach
    void setUp() {
        // validatorFactory = Validation.buildDefaultValidatorFactory();

        validatorFactory = Validation.byDefaultProvider().configure()
                .addValueExtractor(new DataValueExtractor())
                .addValueExtractor(new EntryValueExtractorKey())
                .addValueExtractor(new EntryValueExtractorValue())
                .addValueExtractor(new DataIntegerValueExtractor())
                .buildValidatorFactory();

        validator = validatorFactory.getValidator();
        executableValidator = validator.forExecutables();
    }

    @AfterEach
    void tearDown() {
        validatorFactory.close();
    }

    @Test
    void validate(Object o) {
        Set<ConstraintViolation<Object>> violations = validator.validate(o);
        for (ConstraintViolation<Object> violation : violations) {
            System.out.println(violation.getMessage());
            System.out.println(violation.getPropertyPath());
            System.out.println("===================");
        }
    }

    @Test
    void validateWithGroups(Object o, Class<?>... groups) {
        Set<ConstraintViolation<Object>> violations = validator.validate(o, groups);
        for (ConstraintViolation<Object> violation : violations) {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
            System.out.println("===============");
        }
    }
}
