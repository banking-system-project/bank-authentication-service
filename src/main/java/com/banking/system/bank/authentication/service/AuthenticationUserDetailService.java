package com.banking.system.bank.authentication.service;

import com.banking.system.bank.authentication.bo.AuthenticationBO;
import com.banking.system.bank.authentication.vo.GetUserDetailsOutputVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationUserDetailService implements UserDetailsService {

    @Autowired
    AuthenticationBO authenticationBO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<GetUserDetailsOutputVO> userAuthenticationOutputVO = authenticationBO.getUserDetailsByUserName(username);
        return userAuthenticationOutputVO.map(PostAuthenticatedUserDetailsService::new).orElseThrow(() -> new UsernameNotFoundException("Invalid User"));
    }
}
