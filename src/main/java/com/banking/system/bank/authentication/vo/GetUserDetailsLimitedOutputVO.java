package com.banking.system.bank.authentication.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetUserDetailsLimitedOutputVO {
    private String userId;
    private String emailAdd;
    private String phoneNumber;
    private String role;
    private String lastUpdate;
}
