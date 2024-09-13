package com.banking.system.bank.authentication.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class RegisterUserInputVO {
    @Id
    private String userId;
    private String emailAdd;
    private String phoneNumber;
    private String password;
    private String role;
}
