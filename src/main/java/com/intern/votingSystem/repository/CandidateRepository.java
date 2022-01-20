package com.intern.votingSystem.repository;

import com.intern.votingSystem.model.Candidate;
import com.intern.votingSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer> {

    @Query("Select c from Candidate c order By c.c_id")
    List<Candidate> getCandidateQuery();

    //    @Modifying
//    @Query("Update Candidate setfrom User u where u.id=:id")

    @Modifying
    @Query("Delete from Candidate c where c.c_id=:id")
    void deleteCandidateQuery(@Param("id") int id);

}
