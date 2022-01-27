package com.intern.votingSystem.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.intern.votingSystem.dto.VoteDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vote")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "vote_id")
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vote_id;
    private LocalDateTime voteStartDate;
    private LocalDateTime voteEndDate;
    @OneToOne
//    @JoinColumn(name = "c_id")
    private Candidate candidates;
    @OneToOne
    private User user;

    private Boolean voteStatus;

    public Vote(VoteDTO voteDTO) {
        this.vote_id = voteDTO.getVote_id();
        this.voteStartDate = voteDTO.getVoteStartDate();
        this.voteEndDate = voteDTO.getVoteEndDate();
        this.candidates = voteDTO.getCandidates();
        this.user = voteDTO.getUser();
//        this.user.setId(id);
        this.voteStatus = voteDTO.getVoteStatus();
    }


}
