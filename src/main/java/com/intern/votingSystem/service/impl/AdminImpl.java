package com.intern.votingSystem.service.impl;

import com.intern.votingSystem.dto.AdminDTO;
import com.intern.votingSystem.dto.Message;
import com.intern.votingSystem.model.Admin;
import com.intern.votingSystem.repository.AdminRepository;
import com.intern.votingSystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class AdminImpl implements AdminService {
    @Autowired
    AdminRepository adminRepository;
    @Override
    public AdminDTO addAdmin(AdminDTO adminDTO) {
        Admin admin= new Admin(adminDTO);
        Admin admin1= adminRepository.save(admin);
        AdminDTO adminDTO1= new AdminDTO(admin1);
        return  adminDTO1;
    }

    @Override
    public List<AdminDTO> getAllAdmin() {
        List<Admin> adminList=adminRepository.getAllAdminQuery();
        List<AdminDTO> adminDTOList= new ArrayList<>();
        adminList.forEach(admin -> {
            AdminDTO adminDTO=new AdminDTO(admin);
            adminDTOList.add(adminDTO);
        });
        return adminDTOList;

    }

    @Override
    public String deleteAdmin(int id) {

        if (adminRepository.existsById(id)) {
            adminRepository.deleteAdminQuery(id);
            return Message.setMessage("001", "successfully deleted");

        } else {
            return Message.setMessage("001", "candidate with given id does not exist");

        }
    }
}
