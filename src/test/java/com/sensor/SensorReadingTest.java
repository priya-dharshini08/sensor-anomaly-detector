package com.sensor;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SensorReadingTest {

    @Test
    void testSensorReadingCreation() {
        SensorReading reading = new SensorReading("S1", 25.5, System.currentTimeMillis());
        assertNotNull(reading);
    }
}