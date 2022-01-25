package com.intern.votingSystem.repository;

import com.intern.votingSystem.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Integer> {

    @Query("Select v from Vote v")
    List<Vote> getAllVoteQuery();

//
    @Query(value = "Select v.candidates_c_id, c.candidate_name, count(v.vote_status)" +
            "from vote v inner join candidate c on c.c_id=v.candidates_c_id " +
            "Group By v.candidates_c_id,c.candidate_name", nativeQuery = true)
    List<Object> countCandidateVoteQuery();

//    Select new com.intern.votingSystem.dto.VoteCountDTO candidates_c_id, c.candidate_name, count(vote_status) from vote inner join candidate c on c.c_id=vote.candidates_c_id Group by candidates_c_id, c.candidate_name;
//    @Query("select v.candidates.c_id,c.candidateName, COUNT(v.vote_id), c.candidateCode" +
//            " from Vote v inner join Candidate c on c.c_id=v.vote_id " +
//            "Group By v.candidates.c_id,c.candidateName, c.candidateCode")

//    List<Object> countCandidateVoteQuery();



}
