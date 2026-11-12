package com.sensor;

import java.util.List;

public class AnomalyDetector {
    private int totalReadings;
    private int anomalyCount;
    private List<SensorReading> anomalousReadings;

    // 3-Parameter Constructor
    public AnomalyDetector(int totalReadings, int anomalyCount, List<SensorReading> anomalousReadings) {
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