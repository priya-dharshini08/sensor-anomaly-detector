package com.devops.sensor; 

  

import java.util.EnumMap; 

import java.util.Map; 

  

/** Holds the predefined threshold table for every sensor type. */ 

public class ThresholdConfig { 

  

    private final Map<SensorType, ThresholdRange> ranges = new EnumMap<>(SensorType.class); 

  

    public static ThresholdConfig defaults() { 

        ThresholdConfig cfg = new ThresholdConfig(); 

        cfg.ranges.put(SensorType.TEMPERATURE, new ThresholdRange(15, 75, 5, 90)); 

        cfg.ranges.put(SensorType.PRESSURE,    new ThresholdRange(90, 110, 80, 120)); 

        cfg.ranges.put(SensorType.HUMIDITY,    new ThresholdRange(30, 70, 20, 85)); 

        cfg.ranges.put(SensorType.VIBRATION,   new ThresholdRange(0, 4.5, 0, 7.1)); 

        return cfg; 

    } 

  

    public ThresholdRange get(SensorType type) { 

        ThresholdRange range = ranges.get(type); 

        if (range == null) { 

            throw new IllegalStateException("No thresholds defined for " + type); 

        } 

        return range; 

    } 

  

    public void put(SensorType type, ThresholdRange range) { 

        ranges.put(type, range); 

    } 

} 