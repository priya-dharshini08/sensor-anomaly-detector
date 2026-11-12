package com.devops.sensor; 

  

import java.util.ArrayList; 

import java.util.List; 

  

/** Aggregates classification results into a printable summary. */ 

public class AnomalySummary { 

  

    private final List<ClassifiedReading> all; 

    private int normal; 

    private int warning; 

    private int anomaly; 

  

    public AnomalySummary(List<ClassifiedReading> classified) { 

        this.all = classified; 

        for (ClassifiedReading c : classified) { 

            switch (c.status()) { 

                case NORMAL  -> normal++; 

                case WARNING -> warning++; 

                case ANOMALY -> anomaly++; 

            } 

        } 

    } 

  

    public int total()        { return all.size(); } 

    public int normalCount()  { return normal; } 

    public int warningCount() { return warning; } 

    public int anomalyCount() { return anomaly; } 

  

    public List<ClassifiedReading> byStatus(Status status) { 

        List<ClassifiedReading> out = new ArrayList<>(); 

        for (ClassifiedReading c : all) { 

            if (c.status() == status) { 

                out.add(c); 

            } 

        } 

        return out; 

    } 

  

    public String toReport() { 

        StringBuilder sb = new StringBuilder(); 

        sb.append("========== SENSOR ANOMALY SUMMARY ==========\n"); 

        sb.append("Total readings : ").append(total()).append('\n'); 

        sb.append("Normal         : ").append(normal).append('\n'); 

        sb.append("Warning        : ").append(warning).append('\n'); 

        sb.append("Anomaly        : ").append(anomaly).append('\n'); 

        if (warning > 0) { 

            sb.append("\n--- Warnings ---\n"); 

            byStatus(Status.WARNING).forEach(c -> sb.append(line(c))); 

        } 

        if (anomaly > 0) { 

            sb.append("\n--- Anomalies ---\n"); 

            byStatus(Status.ANOMALY).forEach(c -> sb.append(line(c))); 

        } 

        sb.append("RESULT: ").append(anomaly == 0 ? "PASS (no anomalies)" : "ANOMALIES DETECTED").append('\n'); 

        return sb.toString(); 

    } 

  

    private String line(ClassifiedReading c) { 

        SensorReading r = c.reading(); 

        return String.format("[%s] %s | %s | %s = %s %s%n", 

                c.status(), r.timestamp(), r.sensorId(), r.type(), r.value(), r.type().getUnit()); 

    } 

} 