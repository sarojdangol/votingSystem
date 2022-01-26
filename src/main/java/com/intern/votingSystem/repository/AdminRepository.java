package com.intern.votingSystem.repository;

import com.intern.votingSystem.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

    @Query("Select a from Admin a")
    List<Admin> getAllAdminQuery();

    @Modifying
    @Query("Delete from Admin a where id=:id")
    void deleteAdminQuery(@Param("id") int id);
//
    //    Select new com.intern.votingSystem.dto.VoteCountDTO candidates_c_id,
    //    c.candidate_name, count(vote_status)
    //    from vote inner join
    //    candidate c on c.c_id=vote.candidates_c_id Group by candidates_c_id, c.candidate_name;

    @Query(value = "Select v.candidates_c_id,c.candidate_name,c.candidate_code,COUNT(v.candidates_c_id) " +
            "from vote v " +
            "inner join candidate c on v.candidates_c_id=c.c_id " +
//            "inner join user_details u on u.id=v.user_id" +
            "Group by v.candidates_c_id,c.candidate_name, c.candidate_code" +
            " Order By COUNT(v.candidates_c_id) DESC", nativeQuery = true)
    List<Object> getVoteTableAdminQuery();


//    @Query("Select v.candidate.c_id,c.candidateName,c.candidateCode,COUNT(v.candidate.c_id)" +
//            " from Vote v inner join Candidate c on c.c_id=v.candidate.c_id " +
//            "Group By v.candidate.c_id,c.candidateName,c.candidateCode")

}
