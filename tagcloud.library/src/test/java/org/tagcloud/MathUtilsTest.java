package org.tagcloud;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {

    @Test
    @DisplayName("Normal weight calculation within range")
    void testGetSizeWeightNormal() {
        // value 15 in range 10-20 should be exactly 0.5
        assertEquals(0.5, MathUtils.getSizeWeight(15, 10, 20), 0.0001);
    }

    @Test
    @DisplayName("Should return 0 when range (max - min) is zero to prevent division by zero")
    void testDivisionByZero() {
        assertEquals(0, MathUtils.getSizeWeight(10, 10, 10), "Range of zero should return 0");
    }

    @ParameterizedTest(name = "Value {0} in range {1}-{2} should result in weight {3}")
    @CsvSource({
            "10,  10,  20,  0.0",  // At minimum
            "20,  10,  20,  1.0",  // At maximum
            "5,   10,  20,  0.0",  // Below minimum (clamping)
            "25,  10,  20,  1.0",  // Above maximum (clamping)
            "15,  20,  10,  0.0"   // Inverse range (min > max) results in clamping
    })
    void testBoundariesAndClamping(double value, double min, double max, double expected) {
        assertEquals(expected, MathUtils.getSizeWeight(value, min, max), 0.0001);
    }

    @Test
    @DisplayName("Constructor should be private and throw IllegalStateException")
    void testPrivateConstructor() throws NoSuchMethodException {
        var constructor = MathUtils.class.getDeclaredConstructor();
        assertTrue(java.lang.reflect.Modifier.isPrivate(constructor.getModifiers()), "Constructor is not private");

        constructor.setAccessible(true);
        var exception = assertThrows(java.lang.reflect.InvocationTargetException.class, constructor::newInstance);
        assertInstanceOf(IllegalStateException.class, exception.getCause());
        assertEquals("Utility class", exception.getCause().getMessage());
    }
}