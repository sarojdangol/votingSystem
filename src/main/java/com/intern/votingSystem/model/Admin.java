package com.intern.votingSystem.model;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.Email;


@Data
@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int admin_id;
    private String admin_name;
    @Email
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String password;
}
