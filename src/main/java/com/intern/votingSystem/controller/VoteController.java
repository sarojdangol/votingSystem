package com.intern.votingSystem.controller;

import com.intern.votingSystem.dto.VoteCountDTO;
import com.intern.votingSystem.dto.VoteDTO;
import com.intern.votingSystem.model.Vote;
import com.intern.votingSystem.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vote")
public class VoteController {

    @Autowired
    VoteService voteService;

    @PostMapping
    VoteDTO addVote(@RequestBody VoteDTO voteDTO) {
        return voteService.addVote(voteDTO);
    }

    @GetMapping
    List<VoteDTO> getAllVote() {
        return voteService.getAllCandidateVote();
    }

    @GetMapping("/count")
    List<VoteCountDTO> getVoteCount() {
        return voteService.getCandidateVoteCount();
    }

}
