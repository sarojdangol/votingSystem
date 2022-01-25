package com.intern.votingSystem.service;


import com.intern.votingSystem.dto.AdminDTO;

import java.util.List;

public interface AdminService {
    public AdminDTO addAdmin(AdminDTO adminDTO);
    List<AdminDTO> getAllAdmin();
    String deleteAdmin(int id);
//    List<AdminDTO> getVoteTable();
}
