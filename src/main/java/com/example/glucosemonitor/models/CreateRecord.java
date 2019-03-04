package com.example.glucosemonitor.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@Entity
public class CreateRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Enter glucose level")
    private String glucose;

    @NotBlank(message = "Enter insulin level")
    private String insulin;

    @NotBlank(message = "Enter carbohydrates")
    private String carbs;

    private String note;

    @ManyToOne
    private Category category;

    //public CreateRecord() {}

}
