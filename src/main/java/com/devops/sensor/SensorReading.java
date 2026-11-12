package com.devops.sensor; 

  

/** One raw measurement received from a sensor. */ 

public record SensorReading(String timestamp, String sensorId, SensorType type, double value) { 

} 