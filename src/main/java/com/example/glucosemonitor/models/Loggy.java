package com.example.glucosemonitor.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force=true)
@Entity
public class Loggy {

    @Id
    private final String id;
    private final String name;
    private final Type type;

    public static enum Type {
        GLUCOSE, CARBS, MEDICATION, INSULIN, A1C, BLOODPRESSURE, WEIGHT, KETONES
    }
}
