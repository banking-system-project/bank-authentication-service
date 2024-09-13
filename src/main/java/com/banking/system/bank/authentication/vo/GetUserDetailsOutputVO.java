package com.banking.system.bank.authentication.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetUserDetailsOutputVO {
    private String userId;
    private String emailAdd;
    private String phoneNumber;
    private String role;
    private String isLock;
    private String lastUpdate;
}
