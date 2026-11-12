package com.sensor;

import java.util.List;

public class AnomalySummary {
    private int totalReadings;
    private int anomalyCount;
    private List<SensorReading> anomalousReadings;

    public AnomalySummary(int totalReadings, int anomalyCount, List<SensorReading> anomalousReadings) {
        this.totalReadings = totalReadings;
        this.anomalyCount = anomalyCount;
        this.anomalousReadings = anomalousReadings;
    }

    public int getTotalReadings() {
        return totalReadings;
    }

    public int getAnomalyCount() {
        return anomalyCount;
    }

    public List<SensorReading> getAnomalousReadings() {
        return anomalousReadings;
    }
}