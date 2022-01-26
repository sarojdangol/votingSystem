package com.intern.votingSystem.service;


import com.intern.votingSystem.dto.AdminDTO;
import com.intern.votingSystem.dto.VoteTableAdminDTO;

import java.util.List;

public interface AdminService {
    public AdminDTO addAdmin(AdminDTO adminDTO);
    List<AdminDTO> getAllAdmin();
    String deleteAdmin(int id);
    List<VoteTableAdminDTO> getVoteTable();
}
