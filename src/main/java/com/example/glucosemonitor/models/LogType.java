package com.example.glucosemonitor.models;

public enum LogType {

    GLUCOSE ("Glucose"),
    CARBS ("Carbs"),
    MEDICATION ("Medication"),
    INSULIN ("Insulin"),
    BLOODPRESSURE ("Blood Pressure"),
    WEIGHT ("Weight");

    private final String name;

    LogType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
