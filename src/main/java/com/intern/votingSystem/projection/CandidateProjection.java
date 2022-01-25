package com.intern.votingSystem.projection;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Column;


public interface CandidateProjection {

    int getCandidateId();
    String getCandidateName();
    int getVoteCount();
    String getCandidateCode();


}
