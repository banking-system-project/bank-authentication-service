package com.banking.system.bank.authentication.bo;

import com.banking.system.bank.authentication.config.AuthConfig;
import com.banking.system.bank.authentication.dto.GetUserDetailsOutputDTO;
import com.banking.system.bank.authentication.eo.AuthenticationEO;
import com.banking.system.bank.authentication.util.MapperUtil;
import com.banking.system.bank.authentication.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AuthenticationBO {

    @Autowired
    private AuthenticationEO authenticationEO;

    @Autowired
    private AuthConfig authConfig;

    @Autowired
    private MapperUtil mapperUtil;

    public List<GetUserDetailsLimitedOutputVO> getUserDetails() {
        List<GetUserDetailsOutputDTO> getUserDetailsOutputDTO = authenticationEO.getUserDetails();
        return mapperUtil.getUsersLimitedDetailsOutputListDTOToVO(getUserDetailsOutputDTO);
    }

    public Optional<GetUserDetailsOutputVO> getUserDetailsByUserName(String userName){
        Optional<GetUserDetailsOutputVO> getUserDetailsOutputVO = authenticationEO.getUserDetailsByUserName(userName);
        return getUserDetailsOutputVO;
    }

    public UpdateDetailsOutputVO updateUserPassword(UpdatePasswordInputVO updatePasswordInputVO, String userName) {
        String hashedPassword = authConfig.passwordEncoder().encode(updatePasswordInputVO.getNewPassword());
        return authenticationEO.updateUserPassword(hashedPassword, userName);
    }

    public UpdateDetailsOutputVO updateUserEmail(UpdateEmailInputVO updateEmailInputVO, String userName) {
        return authenticationEO.updateUserEmail(updateEmailInputVO.getNewEmail(), userName);
    }

    public UpdateDetailsOutputVO updateUserPhone(UpdatePhoneInputVO updatePhoneInputVO, String userName) {
        return authenticationEO.updateUserPhone(updatePhoneInputVO.getPhone(), userName);
    }
}
