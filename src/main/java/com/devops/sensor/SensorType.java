package com.devops.sensor; 

  

/** Supported sensor categories and their measurement units. */ 

public enum SensorType { 

    TEMPERATURE("C"), 

    PRESSURE("kPa"), 

    HUMIDITY("%"), 

    VIBRATION("mm/s"); 

  

    private final String unit; 

  

    SensorType(String unit) { 

        this.unit = unit; 

    } 

  

    public String getUnit() { 

        return unit; 

    } 

  

    public static SensorType parse(String text) { 

        try { 

            return SensorType.valueOf(text.trim().toUpperCase()); 

        } catch (IllegalArgumentException | NullPointerException e) { 

            throw new IllegalArgumentException("Unknown sensor type: " + text); 

        } 

    } 

} 