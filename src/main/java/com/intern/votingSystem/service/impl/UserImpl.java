package com.intern.votingSystem.service.impl;

import com.intern.votingSystem.dto.Message;
import com.intern.votingSystem.dto.UserDTO;
import com.intern.votingSystem.model.User;
import com.intern.votingSystem.repository.UserRepository;
import com.intern.votingSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        User user = new User();
        user.userMthd(userDTO);
        User savedUser = userRepository.save(user);
        UserDTO userDTO1 = new UserDTO();
        userDTO1.userDTOMthd(savedUser);
        return userDTO1;
    }

    @Override
    public List<UserDTO> getAllUser() {
        List<User> userList = userRepository.getUserQuery();
        List<UserDTO> userDTOList = new ArrayList<>();
        userList.forEach(user -> {
            UserDTO userDTO = new UserDTO();
            userDTO.userDTOMthd(user);
            userDTOList.add(userDTO);
        });
        return userDTOList;
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        User user = new User();
        user.userMthd(userDTO);
        user.setId(userDTO.getId());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        User updatedUser=userRepository.save(user);
        UserDTO userDTO1=new UserDTO();
        userDTO1.userDTOMthd(updatedUser);
        return userDTO1;

    }


    @Transactional
    @Override
    public String deleteUser(int id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteUserQuery(id);
            return Message.setMessage("001", "succesfully deleted");

        } else {
            return Message.setMessage("001", "user with given id does not exist");

        }

    }
}
