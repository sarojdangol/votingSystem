package com.intern.votingSystem.dto;

import com.intern.votingSystem.model.Admin;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Email;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdminDTO {
    private int id;
    private String adminName;
    private String email;
    private String password;

    public AdminDTO(Admin admin) {
        this.id = admin.getId();
        this.adminName = admin.getAdminName();
        this.email = admin.getEmail();
        this.password = admin.getPassword();
    }
}
