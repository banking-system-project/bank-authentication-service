package com.banking.system.bank.authentication.eo;

import com.banking.system.bank.authentication.dao.AuthenticationDAO;
import com.banking.system.bank.authentication.dto.GetUserDetailsInputDTO;
import com.banking.system.bank.authentication.dto.GetUserDetailsOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthenticationEO {

    @Autowired
    AuthenticationDAO authenticationDAO;

    public List<GetUserDetailsOutputDTO> getUserDetails() {
        List<GetUserDetailsOutputDTO> getUserDetailsOutputDTO = authenticationDAO.getUserDetails();
        return getUserDetailsOutputDTO;
    }
}
