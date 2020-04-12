package com.school.scheduling.serviceimplementation;

import com.school.scheduling.entity.Users;
import com.school.scheduling.repository.Users_Repository;
import com.school.scheduling.service.Services;
import com.school.scheduling.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class UserService_Impl implements UserServices<Users> {

    private Users_Repository repo;

    @Autowired
    public UserService_Impl(Users_Repository repo) {
        this.repo = repo;
    }


    @Override
    public boolean find(String username) {
        for(Users user: repo.findAll()){
            System.out.println("im finding all");
            if(user.getUsername().equals(username)){
                return false;
            }
        }
        return true;
    }
}
