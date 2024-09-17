package com.banking.system.bank.authentication.service;

import com.banking.system.bank.authentication.vo.*;

import java.util.List;

public interface AuthenticationService {
    RegisterUserOutputVO registerUser(RegisterUserInputVO registerUserInputVO);

    List<GetUserDetailsLimitedOutputVO> getUserDetails();

    UpdateDetailsOutputVO updatePassword(UpdatePasswordInputVO updatePasswordInputVO, String userName);
}
