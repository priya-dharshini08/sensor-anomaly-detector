package com.devops.sensor; 

  

import java.util.ArrayList; 

import java.util.List; 

  

/** Classifies readings as NORMAL, WARNING or ANOMALY using predefined thresholds. */ 

public class AnomalyDetector { 

  

    private final ThresholdConfig config; 

  

    public AnomalyDetector() { 

        this(ThresholdConfig.defaults()); 

    } 

  

    public AnomalyDetector(ThresholdConfig config) { 

        this.config = config; 

    } 

  

    public Status classify(SensorReading reading) { 

        return config.get(reading.type()).classify(reading.value()); 

    } 

  

    public List<ClassifiedReading> classifyAll(List<SensorReading> readings) { 

        List<ClassifiedReading> result = new ArrayList<>(); 

        for (SensorReading reading : readings) { 

            result.add(new ClassifiedReading(reading, classify(reading))); 

        } 

        return result; 

    } 

} 