package com.banking.system.bank.authentication.vo;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterUserInputVO {
    private String userId;
    private String emailAdd;
    private String phoneNumber;
    private String password;
    private String role;
}
