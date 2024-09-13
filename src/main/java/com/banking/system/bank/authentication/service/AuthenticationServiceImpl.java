package com.banking.system.bank.authentication.service;

import com.banking.system.bank.authentication.bo.AuthenticationBO;
import com.banking.system.bank.authentication.dto.GetUserDetailsInputDTO;
import com.banking.system.bank.authentication.dto.GetUserDetailsOutputDTO;
import com.banking.system.bank.authentication.util.MapperUtil;
import com.banking.system.bank.authentication.vo.GetUserDetailsInputVO;
import com.banking.system.bank.authentication.vo.GetUserDetailsOutputVO;
import com.banking.system.bank.authentication.vo.RegisterUserInputVO;
import com.banking.system.bank.authentication.vo.RegisterUserOutputVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{

    @Autowired
    AuthenticationBO authenticationBO;

    @Autowired
    MapperUtil mapperUtil;

    @Override
    public RegisterUserOutputVO registerUser(RegisterUserInputVO registerUserInputVO) {
        return null;
    }

    @Override
    public List <GetUserDetailsOutputVO> getUserDetails() {
        List<GetUserDetailsOutputDTO> getUserDetailsListOutputDTO = authenticationBO.getUserDetails();
        return mapperUtil.getUsersDetailsOutputListDTOToVO(getUserDetailsListOutputDTO);
    }
}
