package com.sai.ExpenseTracker_Backend.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AuthRequest {

    @JsonProperty("username")
    private String userName;
    private String Password;
}
