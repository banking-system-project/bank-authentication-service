package com.banking.system.bank.authentication.eo;


import com.banking.system.bank.authentication.dao.AuthenticationDAO;
import com.banking.system.bank.authentication.dto.GetUserDetailsOutputDTO;
import com.banking.system.bank.authentication.vo.GetUserDetailsOutputVO;
import com.banking.system.bank.authentication.vo.UpdateDetailsOutputVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AuthenticationEO {

    private static final Logger logger= LoggerFactory.getLogger(AuthenticationEO.class);

    @Autowired
    AuthenticationDAO authenticationDAO;

    public List<GetUserDetailsOutputDTO> getUserDetails() {
        logger.info("beggining of EO class. get user details");
        List<GetUserDetailsOutputDTO> getUserDetailsOutputDTO = authenticationDAO.getUserDetails();
        logger.info("ending of EO class. get user details");
        return getUserDetailsOutputDTO;
    }

    public Optional<GetUserDetailsOutputVO> getUserDetailsByUserName(String userName) {
        return authenticationDAO.getUserDetailByUserNameAndPassWord(userName);
    }

    public UpdateDetailsOutputVO updateUserPassword(String hashedPassword, String userName) {
        return authenticationDAO.updateUserPassword(hashedPassword, userName);
    }

    public UpdateDetailsOutputVO updateUserEmail(String newEmail, String userName) {
        return authenticationDAO.updateUserEmail(newEmail, userName);
    }

    public UpdateDetailsOutputVO updateUserPhone(String phone, String userName) {
        return authenticationDAO.updateUserPhone(phone, userName);
    }
}
