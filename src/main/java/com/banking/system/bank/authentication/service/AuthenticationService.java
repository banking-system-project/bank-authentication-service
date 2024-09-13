package com.banking.system.bank.authentication.service;

import com.banking.system.bank.authentication.vo.GetUserDetailsInputVO;
import com.banking.system.bank.authentication.vo.GetUserDetailsOutputVO;
import com.banking.system.bank.authentication.vo.RegisterUserInputVO;
import com.banking.system.bank.authentication.vo.RegisterUserOutputVO;

import java.util.List;

public interface AuthenticationService {
    RegisterUserOutputVO registerUser(RegisterUserInputVO registerUserInputVO);

    List<GetUserDetailsOutputVO> getUserDetails();
}
