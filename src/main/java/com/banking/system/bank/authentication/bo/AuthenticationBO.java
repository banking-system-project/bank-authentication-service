package com.banking.system.bank.authentication.bo;

import com.banking.system.bank.authentication.dto.GetUserDetailsOutputDTO;
import com.banking.system.bank.authentication.eo.AuthenticationEO;
import com.banking.system.bank.authentication.util.MapperUtil;
import com.banking.system.bank.authentication.vo.GetUserDetailsLimitedOutputVO;
import com.banking.system.bank.authentication.vo.GetUserDetailsOutputVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AuthenticationBO {

    @Autowired
    AuthenticationEO authenticationEO;

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

}
