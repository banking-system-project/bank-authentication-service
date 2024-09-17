package com.banking.system.bank.authentication.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdatePasswordInputVO {

    private String currentPassword;
    private String newPassword;
}
