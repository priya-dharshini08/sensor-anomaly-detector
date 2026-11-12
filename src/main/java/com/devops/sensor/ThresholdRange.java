package com.devops.sensor; 

  

/** 

 * Predefined limits for one sensor type. 

 * Values inside [normalMin, normalMax] are NORMAL. 

 * Values outside that band but inside [warningMin, warningMax] are WARNING. 

 * Everything else (and any non-numeric value) is an ANOMALY. 

 */ 

public record ThresholdRange(double normalMin, double normalMax, 

                             double warningMin, double warningMax) { 

  

    public ThresholdRange { 

        if (!(warningMin <= normalMin && normalMin <= normalMax && normalMax <= warningMax)) { 

            throw new IllegalArgumentException("Thresholds must satisfy " 

                    + "warningMin <= normalMin <= normalMax <= warningMax"); 

        } 

    } 

  

    public Status classify(double value) { 

        if (Double.isNaN(value) || Double.isInfinite(value)) { 

            return Status.ANOMALY; 

        } 

        if (value >= normalMin && value <= normalMax) { 

            return Status.NORMAL; 

        } 

        if (value >= warningMin && value <= warningMax) { 

            return Status.WARNING; 

        } 

        return Status.ANOMALY; 

    } 

} 