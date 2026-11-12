package com.devops.sensor; 

  

import java.io.IOException; 

import java.nio.file.Files; 

import java.nio.file.Path; 

import java.util.ArrayList; 

import java.util.List; 

  

/** Reads sensor readings from a CSV file: timestamp,sensorId,type,value. */ 

public class CsvReadingLoader { 

  

    public List<SensorReading> load(Path file) throws IOException { 

        List<String> lines = Files.readAllLines(file); 

        List<SensorReading> readings = new ArrayList<>(); 

        for (int i = 1; i < lines.size(); i++) {          // line 0 is the header 

            String line = lines.get(i).trim(); 

            if (line.isEmpty()) { 

                continue; 

            } 

            String[] parts = line.split(","); 

            if (parts.length != 4) { 

                throw new IllegalArgumentException("Line " + (i + 1) + ": expected 4 columns"); 

            } 

            try { 

                readings.add(new SensorReading( 

                        parts[0].trim(), 

                        parts[1].trim(), 

                        SensorType.parse(parts[2]), 

                        Double.parseDouble(parts[3].trim()))); 

            } catch (IllegalArgumentException e) { 

                throw new IllegalArgumentException("Line " + (i + 1) + ": " + e.getMessage()); 

            } 

        } 

        return readings; 

    } 

} 