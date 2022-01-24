package com.intern.votingSystem.projection;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Column;


public interface CandidateProjection {
    String getCandidateName();

    String getCandidateCode();

    int getVote();

//    String getEve();

//    int getEvent_id();


//    String getEventCde();
//
//    String getEventStartDate();
//
//    String getEventEndDate();

}
