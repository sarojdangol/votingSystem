package com.intern.votingSystem.service;

import com.intern.votingSystem.dto.UserDTO;
import com.intern.votingSystem.model.User;

import java.util.List;

public interface UserService {
    UserDTO addUser(UserDTO userDTO);
    List<UserDTO> getAllUser();
    UserDTO updateUser(UserDTO userDTO);
    String deleteUser(int id);
}
