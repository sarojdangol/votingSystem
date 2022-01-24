package com.intern.votingSystem.dto;

import com.intern.votingSystem.model.Candidate;
import com.intern.votingSystem.model.Event;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CandidateDTO {
    private int c_id;
    private String candidateName;
    private String candidateCode;
    private int vote;
    private Event event;

    public void candidateDTOMthd(Candidate candidate) {
        this.c_id = candidate.getC_id();
        this.candidateName = candidate.getCandidateName();
        this.candidateCode = candidate.getCandidateCode();
        this.vote = candidate.getVote();
        this.event = candidate.getEvent();
    }
}
