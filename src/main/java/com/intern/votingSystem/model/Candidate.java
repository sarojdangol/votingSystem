package com.intern.votingSystem.model;

import com.intern.votingSystem.dto.CandidateDTO;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "candidate")
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int c_id;
    private String candidateName;
    @Column(unique = true)
    private String candidateCode;
    private int vote;

    public void candidateMthd(CandidateDTO candidateDTO) {
        this.c_id = candidateDTO.getC_id();
        this.candidateName = candidateDTO.getCandidateName();
        this.candidateCode = candidateDTO.getCandidateCode();
        this.vote = candidateDTO.getVote();
    }
}
