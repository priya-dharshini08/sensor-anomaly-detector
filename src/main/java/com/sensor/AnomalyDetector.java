package com.sensor;

import java.util.ArrayList;
import java.util.List;

public class AnomalyDetector {
    private double maxTemperature;
    private double maxVibration;

    public AnomalyDetector(double maxTemperature, double maxVibration) {
        this.maxTemperature = maxTemperature;
        this.maxVibration = maxVibration;
    }

    public boolean isAnomalous(SensorReading reading) {
        return reading.getTemperature() > maxTemperature || reading.getVibration() > maxVibration;
    }

    public AnomalySummary analyzeReadings(List<SensorReading> readings) {
        List<SensorReading> anomalies = new ArrayList<>();
        for (SensorReading reading : readings) {
            if (isAnomalous(reading)) {
                anomalies.add(reading);
            }
        }
        return new AnomalySummary(readings.size(), anomalies.size(), anomalies);
    }
}