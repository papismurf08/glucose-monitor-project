package com.example.glucosemonitor.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class GlucoseMonitor {

    @NotNull
    @Size(min=3, max=15)
    private String name;

    @NotNull
    @Size(min=1, message = "Description must not be empty")
    private String description;

    private int gmId;
    private static int nextId = 1;

    public GlucoseMonitor(String name, String description) {
        this(); //call the default constructor for the given class
        this.name = name;
        this.description = description;
    }

    public GlucoseMonitor() {
        gmId = nextId;
        nextId++;
    }

    public int getGlucoseMonitorId() {
        return gmId;
    }

    public void setGlucoseMonitorId(int gmId) {
        this.gmId = gmId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
