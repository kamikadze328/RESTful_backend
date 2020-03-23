package com.kamikadze328.testforcv.test2.model;

import lombok.Data;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table
public class ContactInfo {
    @Id
    private long id;

    @Email
    private String email;
    private String city;

    @OneToOne
    @MapsId
    @NotNull
    @RestResource(path = "contactInfoStudents", rel="students")
    private Student student;

    public ContactInfo() {
    }

    public ContactInfo(Student student, String email) {
        this.student = student;
        this.email = email;
    }

    public ContactInfo(Student student, String city, String email) {
        this.student = student;
        this.email = email;
        this.city = city;
    }
}
