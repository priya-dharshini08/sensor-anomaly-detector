package com.sensor;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AnomalyDetectorTest {

    private AnomalyDetector detector;
    private static final double MAX_TEMP_THRESHOLD = 45.0;
    private static final double MAX_VIBRATION_THRESHOLD = 2.5;

    @BeforeEach
    void setUp() {
        detector = new AnomalyDetector(MAX_TEMP_THRESHOLD, MAX_VIBRATION_THRESHOLD);
    }

    @Test
    @DisplayName("Verify Normal Dataset produces zero anomalies")
    void testNormalDataset() throws Exception {
        List<SensorReading> readings = loadReadingsFromCsv("normal_dataset.csv");
        assertFalse(readings.isEmpty(), "Normal dataset should not be empty");

        int anomalyCount = 0;
        for (SensorReading reading : readings) {
            if (detector.isAnomalous(reading)) {
                anomalyCount++;
            }
        }

        assertEquals(0, anomalyCount, "Expected 0 anomalies in normal_dataset.csv");
    }

    @Test
    @DisplayName("Verify Abnormal Dataset flags all threshold breaches")
    void testAbnormalDataset() throws Exception {
        List<SensorReading> readings = loadReadingsFromCsv("abnormal_dataset.csv");
        assertFalse(readings.isEmpty(), "Abnormal dataset should not be empty");

        int anomalyCount = 0;
        for (SensorReading reading : readings) {
            if (detector.isAnomalous(reading)) {
                anomalyCount++;
            }
        }

        assertEquals(readings.size(), anomalyCount, "Expected all records in abnormal_dataset.csv to be flagged");
    }

    private List<SensorReading> loadReadingsFromCsv(String fileName) throws Exception {
        List<SensorReading> readings = new ArrayList<>();
        InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
        assertNotNull(is, "Could not find file in src/test/resources: " + fileName);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
            String line;
            boolean isHeader = true;
            while ((line = reader.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split(",");
                String sensorId = parts[0].trim();
                double temperature = Double.parseDouble(parts[1].trim());
                double vibration = Double.parseDouble(parts[2].trim());

                readings.add(new SensorReading(sensorId, temperature, vibration));
            }
        }
        return readings;
    }
}