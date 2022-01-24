package com.intern.votingSystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.intern.votingSystem.dto.CandidateDTO;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Getter
@Setter
//@Builder
@Entity
@Table(name = "candidate")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "c_id")
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int c_id;
    private String candidateName;
    @Column(unique = true)
    private String candidateCode;
    private int vote;
    @OneToOne
    private Event event;
//    @JsonBackReference


    public void candidateMthd(CandidateDTO candidateDTO) {
        this.c_id = candidateDTO.getC_id();
        this.candidateName = candidateDTO.getCandidateName();
        this.candidateCode = candidateDTO.getCandidateCode();
        this.vote = candidateDTO.getVote();
        this.event = candidateDTO.getEvent();
    }
}
