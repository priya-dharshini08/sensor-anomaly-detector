package com.sensor;

import java.util.ArrayList;
import java.util.List;

public class AnomalySummary {
    private int totalReadings = 0;
    private int normalCount = 0;
    private int warningCount = 0;
    private int anomalyCount = 0;
    private final List<SensorReading> flaggedReadings = new ArrayList<>();

    public void addReading(SensorReading reading) {
        totalReadings++;
        switch (reading.getStatus()) {
            case "Warning":
                warningCount++;
                flaggedReadings.add(reading);
                break;
            case "Anomaly":
                anomalyCount++;
                flaggedReadings.add(reading);
                break;
            default:
                normalCount++;
                break;
        }
    }

    public void printReport() {
        System.out.println("==========================================");
        System.out.println("       SENSOR ANOMALY DETECTION REPORT    ");
        System.out.println("==========================================");
        System.out.println("Total Readings Processed : " + totalReadings);
        System.out.println("Normal Readings          : " + normalCount);
        System.out.println("Warnings Flagged         : " + warningCount);
        System.out.println("Critical Anomalies       : " + anomalyCount);
        System.out.println("------------------------------------------");
        if (!flaggedReadings.isEmpty()) {
            System.out.println("Flagged Events Log:");
            for (SensorReading r : flaggedReadings) {
                System.out.printf(" [%s] Sensor: %s | Type: %s | Value: %.2f\n", 
                    r.getStatus(), r.getSensorId(), r.getSensorType(), r.getValue());
            }
        } else {
            System.out.println("No warnings or anomalies detected.");
        }
        System.out.println("==========================================");
    }

    public int getTotalReadings() { return totalReadings; }
    public int getNormalCount() { return normalCount; }
    public int getWarningCount() { return warningCount; }
    public int getAnomalyCount() { return anomalyCount; }
}