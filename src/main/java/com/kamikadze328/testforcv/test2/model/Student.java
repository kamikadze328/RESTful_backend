package com.kamikadze328.testforcv.test2.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table
public class Student {
    @Id
    @GeneratedValue
    private long id;

    @NotBlank(message = "name is mandatory")
    private String name;

    @ManyToOne
    @JoinColumn(name = "room_number")
    private Room room;

    @ManyToMany
    @JoinTable(
            joinColumns = {@JoinColumn(name = "student_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "subject_id", referencedColumnName = "id")}
    )
    private List<Subject> subjects;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private ContactInfo contactInfo;

    public Student(){
        subjects = new ArrayList<>();
    }
    public Student(String name){
        this();
        this.name = name;
    }
    public Student(String name, Room room){
        this();
        this.name = name;
        this.room = room;
    }
    public Student(String name, ContactInfo contactInfo){
        this();
        this.name = name;
        this.contactInfo = contactInfo;
    }
    public Student(String name, Room room, ContactInfo contactInfo){
        this();
        this.name = name;
        this.room = room;
        this.contactInfo = contactInfo;
    }
}
