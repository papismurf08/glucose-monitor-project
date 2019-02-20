package com.example.glucosemonitor.models;

import lombok.Data;

@Data
public class Property {

    private final String id;
    private final String name;
    private final Type type;

    public static enum Type {
        WEIGHT, BLOODSUGAR //Max,Min,Avg
    }

}
