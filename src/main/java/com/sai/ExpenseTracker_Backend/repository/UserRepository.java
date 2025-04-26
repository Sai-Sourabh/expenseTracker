package com.sai.ExpenseTracker_Backend.repository;

import com.sai.ExpenseTracker_Backend.enitities.UserInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserInfo,Long> {

    UserInfo findByUserName(String userName);
}
