package belajar.unit.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.util.Properties;

public class ConditionalTest {

    @Test
    public void testSystemProperties() {
        Properties properties = System.getProperties();
        properties.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    @Test
    @EnabledOnOs({OS.WINDOWS})
    public void testRunOnlyWindows() {}

    @Test
    @DisabledOnOs({OS.LINUX})
    public void testDisabledOnWindows() {}

    @Test
    @EnabledOnJre({JRE.JAVA_8})
    public void testEnabledOnJava8() {}

    @Test
    @DisabledOnJre({JRE.JAVA_8})
    public void testDisabledOnJava8() {}

    @Test
    @EnabledForJreRange(min = JRE.JAVA_11, max = JRE.JAVA_18)
    public void testEnabledOnJava11To18() {}

    @Test
    @DisabledForJreRange(min = JRE.JAVA_11, max = JRE.JAVA_18)
    public void testDisabledOnJava11To18() {}

    @Test
    @EnabledIfSystemProperties({
            @EnabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    })
    public void testEnabledOnJavaVendorOracle() {}

    @Test
    @DisabledIfSystemProperties({
            @DisabledIfSystemProperty(named = "DEV", matches = "PROFILE")
    })
    public void testDisabledOnJavaVendorOracle() {}

    @Test
    @EnabledIfEnvironmentVariables({
            @EnabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")
    })
    public void testEnabledOnProfileDev() {}

    @Test
    @DisabledIfEnvironmentVariables({
            @DisabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")
    })
    public void testDisabledOnProfileDev() {}

}
