package com.example.glucosemonitor.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date createdAt;

    @ManyToMany(targetEntity = Loggy.class)
    @Size(min=1, message = "You must fill out at least 1 field")
    private List<Loggy> logs = new ArrayList<>();

    @PrePersist
    void createdAt() {
        this.createdAt = new Date();
    }


}
