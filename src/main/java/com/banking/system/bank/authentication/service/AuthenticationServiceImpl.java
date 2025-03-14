package com.banking.system.bank.authentication.service;

import com.banking.system.bank.authentication.bo.AuthenticationBO;
import com.banking.system.bank.authentication.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{

    @Autowired
    AuthenticationBO authenticationBO;

    private static final Logger logger= LoggerFactory.getLogger(AuthenticationServiceImpl.class);


    @Override
    public RegisterUserOutputVO registerUser(RegisterUserInputVO registerUserInputVO) {
        return null;
    }

    @Override
    public List <GetUserDetailsLimitedOutputVO> getUserDetails() {
        logger.info("in the service class. get user details");
        return authenticationBO.getUserDetails();
    }

    public UpdateDetailsOutputVO updatePassword(UpdatePasswordInputVO updatePasswordInputVO, String userName){
        logger.info("in the service class. update password");
        return authenticationBO.updateUserPassword(updatePasswordInputVO, userName);
    }

    @Override
    public UpdateDetailsOutputVO updateEmail(UpdateEmailInputVO updateEmailInputVO, String userName) {
        logger.info("in the service class. update emails");
        return authenticationBO.updateUserEmail(updateEmailInputVO,userName);
    }

    @Override
    public UpdateDetailsOutputVO updatePhone(UpdatePhoneInputVO updatePhoneInputVO, String userName) {
        logger.info("in the service class. update phone");
        return authenticationBO.updateUserPhone(updatePhoneInputVO,userName);
    }
}
