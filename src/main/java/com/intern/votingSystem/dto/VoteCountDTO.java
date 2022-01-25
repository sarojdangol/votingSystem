package com.intern.votingSystem.dto;

import lombok.*;



//@AllArgsConstructor
//@NoArgsConstructor
@Getter
@Setter
public class VoteCountDTO {
    private int candidateId;
    private String candidateName;
    private int voteCount;
//    private String candidateCode;

    public VoteCountDTO() {
    }

    public VoteCountDTO(int candidateId, String candidateName, Long voteCount) {
        this.candidateId = candidateId;
        this.candidateName = candidateName;
        this.voteCount = Math.toIntExact(voteCount);
//        this.candidateCode = candidateCode;

    }

}
