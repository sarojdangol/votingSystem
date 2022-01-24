package com.intern.votingSystem.dto;

import com.intern.votingSystem.model.VoteCount;
import lombok.*;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Getter
@Setter
public class VoteCountDTO {
    private int candidateId;
    private int voteCount;
    private String candidateName;

    public VoteCountDTO() {
    }

    public VoteCountDTO(int candidateId, String candidateName, Long voteCount) {
        this.candidateId = candidateId;
        this.candidateName=candidateName;
        this.voteCount = Integer.parseInt(String.valueOf(voteCount));

    }
    public VoteCountDTO(VoteCount voteCount){
        this.candidateId=voteCount.getCandidateId();
        this.voteCount=voteCount.getVoteCount();
        this.candidateName=voteCount.getCandidateName();
    }
}
