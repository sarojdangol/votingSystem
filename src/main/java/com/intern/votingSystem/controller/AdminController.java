package com.intern.votingSystem.controller;

import com.intern.votingSystem.dto.AdminDTO;
import com.intern.votingSystem.dto.VoteTableAdminDTO;
import com.intern.votingSystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vote/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping
    public AdminDTO addAdmin(@RequestBody AdminDTO adminDTO) {
        return adminService.addAdmin(adminDTO);
    }
    @GetMapping
    public List<AdminDTO> getAllAdmin(){
        return adminService.getAllAdmin();
    }
    @DeleteMapping("/{id}")
    public String deleteAdmin(@PathVariable int id){
        return adminService.deleteAdmin(id);
    }
    @GetMapping("/voteTable")
    public List<VoteTableAdminDTO> getVoteTable(){
        return adminService.getVoteTable();
    }
}
