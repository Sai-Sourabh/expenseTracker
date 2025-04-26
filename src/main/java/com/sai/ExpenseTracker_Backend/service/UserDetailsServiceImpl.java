package com.sai.ExpenseTracker_Backend.service;

import com.sai.ExpenseTracker_Backend.enitities.UserInfo;
import com.sai.ExpenseTracker_Backend.model.UserInfoDto;
import com.sai.ExpenseTracker_Backend.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;


@Component
@Data
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final PasswordEncoder passWordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        UserInfo user = userRepository.findByUserName(username);
        if (user == null){
            throw new UsernameNotFoundException("could not find user...!!!");
        }
        return new CustomUserDetails(user);

    }


    public UserInfo checkIfUserAlreadyExists(UserInfoDto userInfoDto){
        return userRepository.findByUserName(userInfoDto.getUserName());

    }

    public Boolean signupUser(UserInfoDto userInfoDto){
        userInfoDto.setPassword(passWordEncoder.encode(userInfoDto.getPassword()));
        if(Objects.nonNull(checkIfUserAlreadyExists(userInfoDto))){
            return false;
        }
        String userId = UUID.randomUUID().toString();
        userRepository.save(new UserInfo(userId,userInfoDto.getUserName(), userInfoDto.getPassword(),new HashSet<>()));
        return true;
    }
}
