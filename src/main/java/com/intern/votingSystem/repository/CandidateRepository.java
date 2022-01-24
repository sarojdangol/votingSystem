package com.intern.votingSystem.repository;

import com.intern.votingSystem.dto.CandidateDTO;
import com.intern.votingSystem.model.Candidate;
import com.intern.votingSystem.model.User;
import com.intern.votingSystem.projection.CandidateProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer> {

    @Query(value = "Select * from Candidate", nativeQuery = true)
    List<Candidate> getCandidateQuery();

    @Modifying
    @Query("Delete from Candidate c where c.c_id=:id")
    void deleteCandidateQuery(@Param("id") int id);


    //    @Query("SELECT e from Event e inner join e.candidate c where c.c_id=:id")

    @Query("Select c from Candidate c inner join c.event e where c.c_id=:id")
    List<Candidate> getCandidateByEventQuery(@Param("id") int id);

}
