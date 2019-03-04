package com.example.glucosemonitor.models;

public enum GlucoseInfoType {

    GLUCOSE ("Glucose"),
    CARBS ("Carbs"),
    MEDICATION ("Medication"),
    INSULIN ("Insulin"),
    BLOODPRESSURE ("Blood Pressure"),
    WEIGHT ("Weight");

    private final String name;

    GlucoseInfoType(String name) {
        this.name = name;
    }
}
