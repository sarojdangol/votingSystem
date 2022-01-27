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
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class VoteDTO {

    private int vote_id;
    private Candidate candidates;
    private LocalDateTime voteStartDate;
    private LocalDateTime voteEndDate;
    private User user;
    private Boolean voteStatus;

    public VoteDTO() {
    }

    public VoteDTO(int vote_id, Candidate candidates, LocalDateTime voteStartDate, LocalDateTime voteEndDate, User user, Boolean voteStatus) {
        this.vote_id = vote_id;
        this.candidates = candidates;
        this.voteStartDate = voteStartDate;
        this.voteEndDate = voteEndDate;
        this.user = user;
        this.user.setId(user.getId());
        this.voteStatus = voteStatus;
    }

    public void setVote_id(int vote_id) {

        this.vote_id = vote_id;
    }

    public void setCandidates(Candidate candidates) {
        this.candidates = candidates;
    }

    public void setVoteStartDate(LocalDateTime voteStartDate) {

        this.voteStartDate = voteStartDate;
    }

    public void setVoteEndDate(LocalDateTime voteEndDate) {

        this.voteEndDate = voteEndDate;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setVoteStatus(Boolean voteStatus) {
        this.voteStatus = true;
    }

    public VoteDTO(Vote vote) {
        this.vote_id = vote.getVote_id();
        this.voteStartDate = vote.getVoteStartDate();
        this.voteEndDate = vote.getVoteEndDate();
        this.candidates = vote.getCandidates();
        this.user = vote.getUser();
        this.voteStatus = vote.getVoteStatus();
//        this.user.setId(vote.getUser().getId());
    }
}
