package com.example.glucosemonitor.models;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class GlucoseMonitor {

    @NotNull
    @Size(min=3, max=15)
    private String name;

    @NotNull
    @Size(min=1, message = "Description must not be empty")
    private String description;

    public int gmId;
    /*By converting to public according to Spring Boot error, this resolved issue. This is done after
    adding "gm" to modelAttribute in add GET method in controller.*/
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
}
