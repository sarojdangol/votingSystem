package com.intern.votingSystem.dto;

import com.intern.votingSystem.model.Candidate;
import com.intern.votingSystem.model.User;
import lombok.Data;

import javax.persistence.Column;

@Data
public class CandidateDTO {
    private int c_id;
    private String candidateName;
    private String candidateCode;
    private int vote;

    public void candidateDTOMthd(Candidate candidate) {
        this.c_id = candidate.getC_id();
        this.candidateName = candidate.getCandidateName();
        this.candidateCode = candidate.getCandidateCode();
        this.vote = candidate.getVote();
            }
}
