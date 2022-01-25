package com.intern.votingSystem.repository;

import com.intern.votingSystem.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer> {

    @Query("Select a from Admin a")
    List<Admin> getAllAdminQuery();

    @Query("Delete from Admin a where id=:id")
    void deleteAdminQuery(@Param("id") int id);


}
