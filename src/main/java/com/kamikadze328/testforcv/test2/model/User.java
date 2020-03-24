package com.kamikadze328.testforcv.test2.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "users")
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private long id;

    @NotNull
    private String username;

    @NotNull
    private String password;

    private String role;

    public User(){}
}
