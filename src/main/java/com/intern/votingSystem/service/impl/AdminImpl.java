package com.intern.votingSystem.service.impl;

import com.intern.votingSystem.dto.AdminDTO;
import com.intern.votingSystem.dto.Message;
import com.intern.votingSystem.dto.VoteTableAdminDTO;
import com.intern.votingSystem.model.Admin;
import com.intern.votingSystem.repository.AdminRepository;
import com.intern.votingSystem.service.AdminService;
import org.aspectj.runtime.internal.Conversions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


@Service
public class AdminImpl implements AdminService {
    @Autowired
    AdminRepository adminRepository;

    @Override
    public AdminDTO addAdmin(AdminDTO adminDTO) {
        Admin admin = new Admin(adminDTO);
        Admin admin1 = adminRepository.save(admin);
        AdminDTO adminDTO1 = new AdminDTO(admin1);
        return adminDTO1;
    }

    @Override
    public List<AdminDTO> getAllAdmin() {
        List<Admin> adminList = adminRepository.getAllAdminQuery();
        List<AdminDTO> adminDTOList = new ArrayList<>();
        adminList.forEach(admin -> {
            AdminDTO adminDTO = new AdminDTO(admin);
            adminDTOList.add(adminDTO);
        });
        return adminDTOList;

    }

    @Transactional
    @Override
    public String deleteAdmin(int id) {

        if (adminRepository.existsById(id)) {
            adminRepository.deleteAdminQuery(id);
            return Message.setMessage("001", "successfully deleted");

        } else {
            return Message.setMessage("001", "candidate with given id does not exist");

        }
    }

    @Override
    public List<VoteTableAdminDTO> getVoteTable() {
        List<Object> voteTableAdminList = adminRepository.getVoteTableAdminQuery();
//        System.out.println(voteTableAdminList);
        List<VoteTableAdminDTO> voteTableAdminDTOList = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < voteTableAdminList.size(); i++) {
            count++;
//            System.out.println(count);
        }
//        System.out.println(count);
        AtomicInteger tableHalf = new AtomicInteger((int)Math.ceil (count/2.00));
//        System.out.println(tableHalf);

        voteTableAdminList.forEach(voteTable -> {
            Object[] voteListTable = (Object[]) voteTable;
            VoteTableAdminDTO voteTableAdminDTO = new VoteTableAdminDTO();
            voteTableAdminDTO.setId((int) voteListTable[0]);
            voteTableAdminDTO.setCandidateName((String) voteListTable[1]);
            voteTableAdminDTO.setCandidateCode((String) voteListTable[2]);
            voteTableAdminDTO.setVoteCount(Conversions.intValue(voteListTable[3]));
//            voteTableAdminDTO.setUserName((String)voteListTable[4]);
            if (tableHalf.get() >0) {
                System.out.println(tableHalf);
                tableHalf.set(tableHalf.get() - 1);

                voteTableAdminDTO.setFlag(1);
//                System.out.println(tableHalf);
            }
            voteTableAdminDTOList.add(voteTableAdminDTO);
        });
        return voteTableAdminDTOList;
    }
}
