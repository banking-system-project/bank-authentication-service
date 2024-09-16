package com.banking.system.bank.authentication.eo;

import com.banking.system.bank.authentication.dao.AuthenticationDAO;
import com.banking.system.bank.authentication.dto.GetUserDetailsOutputDTO;
import com.banking.system.bank.authentication.vo.GetUserDetailsOutputVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AuthenticationEO {

    @Autowired
    AuthenticationDAO authenticationDAO;

    public List<GetUserDetailsOutputDTO> getUserDetails() {
        List<GetUserDetailsOutputDTO> getUserDetailsOutputDTO = authenticationDAO.getUserDetails();
        return getUserDetailsOutputDTO;
    }

    public Optional<GetUserDetailsOutputVO> getUserDetailsByUserName(String userName) {
        return authenticationDAO.getUserDetailByUserNameAndPassWord(userName);
    }
}
