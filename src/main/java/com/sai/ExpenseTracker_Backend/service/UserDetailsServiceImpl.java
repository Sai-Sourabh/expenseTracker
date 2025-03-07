package com.sai.ExpenseTracker_Backend.service;

import com.sai.ExpenseTracker_Backend.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;



@Component
@Data
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    private final UserRepository userRepository;







    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
