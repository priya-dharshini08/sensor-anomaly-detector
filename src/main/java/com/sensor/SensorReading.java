package com.sensor;

public class SensorReading {
    private String sensorId;
    private String timestamp;
    private String sensorType;
    private double value;
    private String status;

    public SensorReading(String sensorId, String timestamp, String sensorType, double value) {
        this.sensorId = sensorId;
        this.timestamp = timestamp;
        this.sensorType = sensorType;
        this.value = value;
        this.status = "Normal";
    }

    public String getSensorId() { return sensorId; }
    public String getTimestamp() { return timestamp; }
    public String getSensorType() { return sensorType; }
    public double getValue() { return value; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}