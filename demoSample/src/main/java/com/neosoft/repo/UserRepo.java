package com.neosoft.repo;

import com.neosoft.model.User;
import com.neosoft.model.UserDtls;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;
@Repository
public interface UserRepo extends JpaRepository<User,Integer> {


    User findByUserName(String userName);


}
