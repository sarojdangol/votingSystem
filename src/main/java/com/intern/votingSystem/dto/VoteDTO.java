package com.intern.votingSystem.dto;

import com.intern.votingSystem.model.Candidate;
import com.intern.votingSystem.model.Event;
import com.intern.votingSystem.model.User;
import com.intern.votingSystem.model.Vote;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VoteDTO {

    private int vote_id;
    private Candidate candidates;
    private LocalDateTime voteStartDate;
    private LocalDateTime voteEndDate;
    private User user;
    private Boolean voteStatus;


    public VoteDTO(Vote vote) {
        this.vote_id = vote.getVote_id();
        this.voteStartDate = vote.getVoteStartDate();
        this.voteEndDate = vote.getVoteEndDate();
        this.candidates = vote.getCandidates();
        this.user = vote.getUser();
        this.voteStatus = vote.getVoteStatus();

    }
}
