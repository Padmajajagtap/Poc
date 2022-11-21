package com.neosoft.service;

import com.neosoft.model.User;
import com.neosoft.model.UserDtls;
import com.neosoft.repo.UserDtlsRepo;
import com.neosoft.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl {

    @Autowired
    UserRepo userRepo;
    @Autowired
    UserDtlsRepo userDtlsRepo;

    public UserDtls saveData(UserDtls userDtls) {

        return userDtlsRepo.save(userDtls);
    }

    public List<User> getAllData() {
        return userRepo.findAll();
    }


    public List<UserDtls> listAll(String query) {
        if (query != null) {
            return userDtlsRepo.searchUserDetails(query);
        }
        return userDtlsRepo.findAll();
    }
}

    /* public void searchBy(Object object) {
     *//* userRepo.*//*
    }*/



