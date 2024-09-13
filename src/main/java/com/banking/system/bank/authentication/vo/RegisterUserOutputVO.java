package com.banking.system.bank.authentication.vo;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterUserOutputVO {
    private String userId;
    private String emailAdd;
    private String phoneNumber;
    private String role;
    private String lastUpdate;
}
