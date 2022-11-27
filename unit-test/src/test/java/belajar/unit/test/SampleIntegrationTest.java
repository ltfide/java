package belajar.unit.test;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@Tags({
        @Tag("integration-test")
})
public class SampleIntegrationTest {

    @Test
    void test1() {
        assertTrue(true);
    }

    @Test
    void test2() {
    }

}
