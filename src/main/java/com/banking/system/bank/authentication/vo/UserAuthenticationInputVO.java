package com.banking.system.bank.authentication.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserAuthenticationInputVO {
    private String userId;
    private String password;
}
