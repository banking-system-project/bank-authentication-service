package com.banking.system.bank.authentication.service;

import com.banking.system.bank.authentication.bo.AuthenticationBO;
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
        return authenticationBO.getUserDetails();
    }

    public UpdateDetailsOutputVO updatePassword(UpdatePasswordInputVO updatePasswordInputVO, String userName){
        return authenticationBO.updateUserPassword(updatePasswordInputVO, userName);
    }

    @Override
    public UpdateDetailsOutputVO updateEmail(UpdateEmailInputVO updateEmailInputVO, String userName) {
        return authenticationBO.updateUserEmail(updateEmailInputVO,userName);
    }

    @Override
    public UpdateDetailsOutputVO updatePhone(UpdatePhoneInputVO updatePhoneInputVO, String userName) {
        return authenticationBO.updateUserPhone(updatePhoneInputVO,userName);
    }
}
