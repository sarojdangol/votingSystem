package com.intern.votingSystem.controller;

import com.intern.votingSystem.dto.UserDTO;
import com.intern.votingSystem.dto.VoteDTO;
import com.intern.votingSystem.service.UserService;
import com.intern.votingSystem.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vote/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    VoteService voteService;

    @PostMapping
    public UserDTO addUser(@RequestBody UserDTO userDTO) {
        return userService.addUser(userDTO);
    }

    @GetMapping
    public List<UserDTO> getAllUser() {
        return userService.getAllUser();
    }

    @PutMapping
    public UserDTO updateUser(@RequestBody UserDTO userDTO) {
        return userService.updateUser(userDTO);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }

    @PostMapping("/voteCandidate")
    VoteDTO voteCandidate(@RequestBody VoteDTO voteDTO) {
        return voteService.addVote(voteDTO);
    }

}

