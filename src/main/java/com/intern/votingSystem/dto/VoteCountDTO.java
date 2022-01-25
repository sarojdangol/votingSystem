package com.intern.votingSystem.dto;

import com.intern.votingSystem.model.VoteCount;
import lombok.*;
import org.springframework.data.jpa.repository.query.AbstractJpaQuery;

import java.util.List;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Getter
@Setter
public class VoteCountDTO {
    private int candidateId;
    private String candidateName;
    private int  voteCount;
    private String candidateCode;

    public VoteCountDTO() {
    }

    public VoteCountDTO(int candidateId, String candidateName, Long voteCount, String candidateCode) {
        this.candidateId = candidateId;
        this.candidateName = candidateName;
        this.voteCount = Math.toIntExact(voteCount);
        this.candidateCode = candidateCode;

    }

    public VoteCountDTO(VoteCount voteCount) {
        this.candidateId = voteCount.getCandidateId();
        this.candidateName = voteCount.getCandidateName();
        this.voteCount = voteCount.getVoteCount();
        this.candidateCode = voteCount.getCandidateCode();
    }
}
