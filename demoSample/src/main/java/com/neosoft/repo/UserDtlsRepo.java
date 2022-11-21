package com.neosoft.repo;

import com.neosoft.model.UserDtls;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserDtlsRepo extends JpaRepository<UserDtls,Integer>
{

    @Query("SELECT p FROM UserDtls p WHERE CONCAT(p.firstName, ' ', p.lastName, ' ', p.country,' ', p.state,' ', p.city) LIKE %?1%")
    List<UserDtls> searchUserDetails(String query);
}
