package com.banking.system.bank.authentication.service;

import com.banking.system.bank.authentication.bo.AuthenticationBO;
import com.banking.system.bank.authentication.dto.GetUserDetailsInputDTO;
import com.banking.system.bank.authentication.dto.GetUserDetailsOutputDTO;
import com.banking.system.bank.authentication.util.MapperUtil;
import com.banking.system.bank.authentication.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{

    @Autowired
    AuthenticationBO authenticationBO;


    @Override
    public RegisterUserOutputVO registerUser(RegisterUserInputVO registerUserInputVO) {
        return null;
    }

    @Override
    public List <GetUserDetailsLimitedOutputVO> getUserDetails() {
        List<GetUserDetailsLimitedOutputVO> getUserDetailsListOutputVO = authenticationBO.getUserDetails();
        return getUserDetailsListOutputVO;
    }
}
