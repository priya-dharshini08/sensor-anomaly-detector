package com.sensor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AnomalyDetector {

    public List<SensorReading> loadDataset(String filePath) throws IOException {
        List<SensorReading> readings = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue; // Skip CSV header row
                }
                String[] parts = line.split(",");
                if (parts.length >= 4) {
                    readings.add(new SensorReading(
                        parts[0].trim(), 
                        parts[1].trim(), 
                        parts[2].trim(), 
                        Double.parseDouble(parts[3].trim())
                    ));
                }
            }
        }
        return readings;
    }

    public AnomalySummary evaluateReadings(List<SensorReading> readings) {
        AnomalySummary summary = new AnomalySummary();
        for (SensorReading reading : readings) {
            classify(reading);
            summary.addReading(reading);
        }
        return summary;
    }

    private void classify(SensorReading reading) {
        double val = reading.getValue();
        switch (reading.getSensorType().toLowerCase()) {
            case "temperature":
                if (val > 80.0) {
                    reading.setStatus("Anomaly");
                } else if (val > 60.0) {
                    reading.setStatus("Warning");
                } else {
                    reading.setStatus("Normal");
                }
                break;
            case "pressure":
                if (val > 150.0 || val < 20.0) {
                    reading.setStatus("Anomaly");
                } else if (val > 120.0 || val < 40.0) {
                    reading.setStatus("Warning");
                } else {
                    reading.setStatus("Normal");
                }
                break;
            default:
                reading.setStatus("Normal");
                break;
        }
    }
}