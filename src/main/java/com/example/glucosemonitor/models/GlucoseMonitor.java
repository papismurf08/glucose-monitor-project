package com.example.glucosemonitor.models;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
@Entity
public class GlucoseMonitor {

    //private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    //private int id;
    /*By converting to public according to Spring Boot error, this resolved issue. This is done after
    adding "gm" to modelAttribute in add GET method in controller.*/
    //UPDATE: converted back to private and no issues, yay!
    //private static int nextId = 1;

    //private Date placedAt;

    /*@NotNull
    @Size(min=3, max=15)
    private String name;*/
    private LogType type;

    @NotBlank(message = "Enter glucose level")
    private String glucose;

    @NotBlank(message = "Enter insulin level")
    private String insulin;

    @NotBlank(message = "Enter carbohydrates")
    private String carbs;

    private String note;

    //private Property type;

    /*public GlucoseMonitor(String name, String description) {
        this.name = name;
        this.description = description;*/

    /*public int getId() {
        return id;
    }*/
}
