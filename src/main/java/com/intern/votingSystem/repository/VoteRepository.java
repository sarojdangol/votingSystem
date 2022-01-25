package com.intern.votingSystem.repository;

import com.intern.votingSystem.dto.VoteCountDTO;
import com.intern.votingSystem.dto.VoteDTO;
import com.intern.votingSystem.model.Vote;
import com.intern.votingSystem.model.VoteCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Repository;

import java.sql.SQLOutput;
import java.util.List;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Integer> {

    @Query("Select v from Vote v")
    List<Vote> getAllVoteQuery();


//    @Query(value = "Select v.candidates_c_id, c.candidate_name, count(v.vote_status), c.candidate_code" +
//            "from vote v inner join candidate c on c.c_id=v.candidates_c_id " +
//            "Group By v.candidates_c_id,c.candidate_name, c.candidate_code", nativeQuery = true)
//    Select new com.intern.votingSystem.dto.VoteCountDTO candidates_c_id, c.candidate_name, count(vote_status) from vote inner join candidate c on c.c_id=vote.candidates_c_id Group by candidates_c_id, c.candidate_name;
    @Query("select v.candidates.c_id,c.candidateName, COUNT(v.vote_id), c.candidateCode" +
            " from Vote v inner join Candidate c on c.c_id=v.vote_id " +
            "Group By v.candidates.c_id,c.candidateName, c.candidateCode")
        List<Object> countCandidateVoteQuery();

//    List<Object> countCandidateVoteQuery();



}
