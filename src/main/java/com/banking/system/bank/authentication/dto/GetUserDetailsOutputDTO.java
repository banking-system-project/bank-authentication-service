package com.banking.system.bank.authentication.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetUserDetailsOutputDTO {
    private String userId;
    private String emailAdd;
    private String phoneNumber;
    private String password;
    private String role;
    private String isLock;
    private String createdAt;
    private String lastUpdate;

}
