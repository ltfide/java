package com.validation;

import java.util.Set;

import org.junit.jupiter.api.Test;

import com.validation.data.SampleData;
import com.validation.data.SampleDataInteger;
import com.validation.data.SampleEntry;
import com.validation.data.container.Data;
import com.validation.data.container.DataInteger;
import com.validation.data.container.Entry;

import jakarta.validation.ConstraintViolation;

public class ValueExtractorTest extends AbstractValidatorTest {

    @Test
    void testSampleData() {

        SampleData data = new SampleData();
        data.setData(new Data<>());
        data.getData().setData("   ");

        Set<ConstraintViolation<SampleData>> violations = validator.validate(data);
        for (ConstraintViolation<SampleData> violation : violations) {
            System.out.println(violation.getMessage());
            System.out.println(violation.getPropertyPath());
            System.out.println("================");
        }

        // output
        // must not be blank
        // data
        // ================
        // size must be between 10 and 2147483647
        // data
        // ================
    }

    @Test
    void testSampleEntry() {

        SampleEntry sampleEntry = new SampleEntry();
        sampleEntry.setEntry(new Entry<>());
        sampleEntry.getEntry().setKey("");
        sampleEntry.getEntry().setValue("");

        Set<ConstraintViolation<SampleEntry>> violations = validator.validate(sampleEntry);
        for (ConstraintViolation<SampleEntry> violation : violations) {
            System.out.println(violation.getMessage());
            System.out.println(violation.getPropertyPath());
            System.out.println("================");
        }

        // output
        // must not be blank
        // entry<V>[value]
        // ===================
        // must not be blank
        // entry<K>[key]
        // ===================
    }

    @Test
    void testSampleDataInteger() {

        SampleDataInteger sampleDataInteger = new SampleDataInteger();
        sampleDataInteger.setData(new DataInteger());
        sampleDataInteger.getData().setData(0);

        Set<ConstraintViolation<SampleDataInteger>> violations = validator.validate(sampleDataInteger);
        for (ConstraintViolation<SampleDataInteger> violation : violations) {
            System.out.println(violation.getMessage()); // must be greater than or equal to 10
            System.out.println(violation.getPropertyPath()); // data
        }
    }
}
