package com.intern.votingSystem.repository;

import com.intern.votingSystem.dto.VoteDTO;
import com.intern.votingSystem.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Integer> {

    @Query("Select v from Vote v")
    List<Vote> getAllVoteQuery();

//    @Query("Select v from Vote v inner join v.candidate c where c.c_id=id")
//    List<Vote> countCandidateVoteQuery();
}
