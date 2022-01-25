package com.intern.votingSystem.service.impl;

import com.intern.votingSystem.dto.VoteCountDTO;
import com.intern.votingSystem.dto.VoteDTO;
import com.intern.votingSystem.model.Vote;
import com.intern.votingSystem.repository.VoteRepository;
import com.intern.votingSystem.service.VoteService;
import org.aspectj.runtime.internal.Conversions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
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
        List<Object> voteList = voteRepository.countCandidateVoteQuery();
        System.out.println(voteList);
        List<VoteCountDTO> response = new ArrayList<>();

        voteList.forEach(vote -> {
            Object[] voteListObject= (Object[]) vote;
            VoteCountDTO voteCountDTO= new VoteCountDTO();
            voteCountDTO.setCandidateId((int) voteListObject[0]);
            voteCountDTO.setCandidateName((String) voteListObject[1]);
            voteCountDTO.setVoteCount(Conversions.intValue(voteListObject[2]));
//            voteCountDTO.setVoteCount(Math.toIntExact((Long)voteListObject[2]));
//            voteCountDTO.setCandidateCode((String) voteListObject[3]);
            response.add(voteCountDTO);
        });
        return response;
//        List<Object> voteObjects =voteRepository.countCandidateVoteQuery();
//        System.out.println(voteObjects);
//        List<Object> voteObjectList= new ArrayList<>();
//
////        voteObjects.forEach(vote->{
////            voteObjectList.add(vote);
////        });
//        return voteObjects;
    }
}
