package com.intern.votingSystem.model;

import com.intern.votingSystem.dto.AdminDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String adminName;
    @Email
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String password;

    public Admin(AdminDTO adminDTO){
        this.id=adminDTO.getId();
        this.adminName=adminDTO.getAdminName();
        this.email=adminDTO.getEmail();
        this.password=adminDTO.getPassword();
    }
}
