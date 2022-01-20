package com.intern.votingSystem.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "vote")
public class Vote {

    private int vote_id;
    private int event_id;
    private int candidate_id;
    private int voteCount;
}
