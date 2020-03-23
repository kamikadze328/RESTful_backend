package com.kamikadze328.testforcv.test2.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Entity
@Table
public class Subject {

    @Id
    @GeneratedValue
    private long id;

    @NotBlank(message = "name is mandatory")
    private String name;

    @ManyToMany(mappedBy = "subjects")
    private List<Student> students;

    public Subject(){}

    public Subject(String name){
        this.name = name;
    }

}
