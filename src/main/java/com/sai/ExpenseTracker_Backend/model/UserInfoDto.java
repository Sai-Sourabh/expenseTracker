package com.sai.ExpenseTracker_Backend.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.sai.ExpenseTracker_Backend.enitities.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserInfoDto extends UserInfo {

    @JsonProperty("username")
    private String userName;

    private String lastName;


    private String phoneNumber;

    private String email;
}
