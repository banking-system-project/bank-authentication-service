package com.banking.system.bank.authentication.vo;
import lombok.*;

@Getter
@Setter
@ToString
public class GetUserDetailsOutputVO {
    private String userId;
    private String emailAdd;
    private String phoneNumber;
    private String password;
    private String role;
    private String isLock;
    private String lastUpdate;
}
