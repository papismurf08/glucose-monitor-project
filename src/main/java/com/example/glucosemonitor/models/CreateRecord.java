package com.example.glucosemonitor.models;

import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Entity
//@Table(name = "create_record")
public class CreateRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    //@Digits(integer=3, fraction=0, message = "Enter glucose level")
    @NotNull(message = "Enter glucose level")
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
