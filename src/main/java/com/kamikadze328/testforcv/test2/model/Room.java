package com.kamikadze328.testforcv.test2.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table
public class Room {
    @Id
    @GeneratedValue
    private long number;

    @OneToMany(mappedBy = "room")
    private List<Student> students;

}
