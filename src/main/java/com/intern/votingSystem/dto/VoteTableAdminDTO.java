package com.intern.votingSystem.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class VoteTableAdminDTO {
    private int id;
    private String candidateName;
    private String candidateCode;
    private int voteCount;
    private int flag;
//    private String userName;

    public VoteTableAdminDTO(int id, String candidateName, String candidateCode, Long voteCount,int flag) {
        this.id = id;
        this.candidateName = candidateName;
        this.candidateCode = candidateCode;
        this.voteCount = Math.toIntExact(voteCount);
        this.flag=flag;
//        this.userName = userName;
    }
}
