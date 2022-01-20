package com.intern.votingSystem.repository;

import com.intern.votingSystem.dto.UserDTO;
import com.intern.votingSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query("Select u from User u order By u.id")
    List<User> getUserQuery();

    @Modifying
    @Query("Delete from User u where u.id=:id")
    void deleteUserQuery(@Param("id") int id);

}
