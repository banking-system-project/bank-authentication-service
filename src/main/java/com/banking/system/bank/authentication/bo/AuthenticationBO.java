package com.banking.system.bank.authentication.bo;

import com.banking.system.bank.authentication.dto.GetUserDetailsInputDTO;
import com.banking.system.bank.authentication.dto.GetUserDetailsOutputDTO;
import com.banking.system.bank.authentication.eo.AuthenticationEO;
import com.banking.system.bank.authentication.vo.GetUserDetailsOutputVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthenticationBO {

    @Autowired
    AuthenticationEO authenticationEO;

    public List<GetUserDetailsOutputDTO> getUserDetails() {
        List<GetUserDetailsOutputDTO> getUserDetailsOutputDTO = authenticationEO.getUserDetails();
        return getUserDetailsOutputDTO;
    }
}
