package com.sai.ExpenseTracker_Backend.service;

import com.sai.ExpenseTracker_Backend.enitities.RefreshToken;
import com.sai.ExpenseTracker_Backend.enitities.UserInfo;
import com.sai.ExpenseTracker_Backend.repository.RefreshTokenRepository;
import com.sai.ExpenseTracker_Backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
public class RefreshTokenService {

    @Autowired
    RefreshTokenRepository refreshTokenRepository;

    @Autowired
    UserRepository userRepository;


    public RefreshToken createRefreshToken(String userName){
        Optional<UserInfo> userInfoExtracted = userRepository.findByUserName(userName);
        UserInfo userInfo = userInfoExtracted.get();
        RefreshToken refreshToken = RefreshToken.builder()
                .userInfo(userInfo)
                .token(UUID.randomUUID().toString())
                .expiryDate(Instant.now().plusMillis(600000))
                .build();

        return refreshTokenRepository.save(refreshToken);

    }

    public RefreshToken verifyExpiration(RefreshToken token){
        if(token.getExpiryDate().compareTo(Instant.now())<0){
            refreshTokenRepository.delete(token);
            throw new RuntimeException(token.getToken() + " Refresh token is expired. please login again..!");
        }
        return token;
    }


}
