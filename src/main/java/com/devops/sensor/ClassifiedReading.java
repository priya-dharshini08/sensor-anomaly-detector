package com.devops.sensor; 

  

/** A sensor reading together with its classification. */ 

public record ClassifiedReading(SensorReading reading, Status status) { 

} 