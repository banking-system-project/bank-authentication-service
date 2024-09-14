package com.banking.system.bank.authentication.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class GetUserDetailsOutputVO {
    private String userId;
    private String emailAdd;
    private String phoneNumber;
    private String password;
    private String role;
    private String isLock;
    private String lastUpdate;
}
