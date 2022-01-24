package com.intern.votingSystem.service.impl;

import com.intern.votingSystem.dto.VoteCountDTO;
import com.intern.votingSystem.dto.VoteDTO;
import com.intern.votingSystem.model.Vote;
import com.intern.votingSystem.model.VoteCount;
import com.intern.votingSystem.repository.VoteRepository;
import com.intern.votingSystem.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VoteImpl implements VoteService {
    @Autowired
    VoteRepository voteRepository;

    @Override
    public VoteDTO addVote(VoteDTO voteDTO) {

        Vote vote = new Vote(voteDTO);
        Vote savedVote = voteRepository.save(vote);
        VoteDTO voteDTO1 = new VoteDTO(savedVote);
        return voteDTO1;
    }

    @Override
    public List<VoteDTO> getAllCandidateVote() {
        List<Vote> voteList = voteRepository.getAllVoteQuery();
        List<VoteDTO> voteDTOList = new ArrayList<>();
        voteList.forEach(vote -> {
            VoteDTO voteDTO = new VoteDTO(vote);
            voteDTOList.add(voteDTO);
        });
        return voteDTOList;
    }

    @Override
    public List<VoteCountDTO> getCandidateVoteCount() {
        List<VoteCount> voteList =voteRepository.countCandidateVoteQuery();
//        List<Object> voteObjects =voteRepository.countCandidateVoteQuery();
//        System.out.println(voteObjects);
        List<VoteCountDTO> voteCountDTOS = new ArrayList<>();
        voteList.forEach(vote -> {
            VoteCountDTO voteCountDTO= new VoteCountDTO(vote);
            voteCountDTOS.add(voteCountDTO);
        });
        return voteCountDTOS;
//        return  null;
    }
}
