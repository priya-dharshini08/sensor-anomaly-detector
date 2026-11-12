package com.sensor;

public class SensorReading {
    private String sensorId;
    private double temperature;
    private double vibration;

    public SensorReading(String sensorId, double temperature, double vibration) {
        this.sensorId = sensorId;
        this.temperature = temperature;
        this.vibration = vibration;
    }

    public String getSensorId() {
        return sensorId;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getVibration() {
        return vibration;
    }
}