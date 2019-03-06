package com.example.glucosemonitor.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//@Table(name = "product")
@Data
@Entity
public class Chart {

    //private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(targetEntity = CreateRecord.class)
    private List<CreateRecord> stats = new ArrayList<>();
}
/*@Entity
public class Chart implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    public String id;
    public String name;
    public double price;
    public int quantity;
    private boolean status;
}*/

