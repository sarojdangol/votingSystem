package com.intern.votingSystem.model;

import com.intern.votingSystem.dto.VoteCountDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VoteCount {
    private int candidateId;
    private String candidateName;
    private int voteCount;
    private String candidateCode;


    public VoteCount(VoteCountDTO voteCountDTO) {
        this.candidateId = voteCountDTO.getCandidateId();
        this.voteCount = voteCountDTO.getVoteCount();
        this.candidateName = voteCountDTO.getCandidateName();
        this.candidateCode = voteCountDTO.getCandidateCode();
    }
}
