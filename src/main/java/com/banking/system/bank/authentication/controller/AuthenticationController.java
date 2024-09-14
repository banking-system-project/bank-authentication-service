package com.banking.system.bank.authentication.controller;

import com.banking.system.bank.authentication.service.AuthenticationService;
import com.banking.system.bank.authentication.service.AuthenticationServiceImpl;
import com.banking.system.bank.authentication.service.JwtService;
import com.banking.system.bank.authentication.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank/authentication")
public class AuthenticationController {

    @Autowired
    AuthenticationServiceImpl authenticationService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @PostMapping(value = "/user/register")
    public ResponseEntity<RegisterUserOutputVO> registerUser(@RequestBody RegisterUserInputVO registerUserInputVO){
        RegisterUserOutputVO registerUserOutputVO = authenticationService.registerUser(registerUserInputVO);
        return new ResponseEntity<>(registerUserOutputVO, HttpStatus.OK);
    }
    @PostMapping(value = "/user/details")
    //@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<Object> getUsers(){
        List<GetUserDetailsOutputVO> getUserOutputDetailsVO = authenticationService.getUserDetails();
        return new ResponseEntity<>(getUserOutputDetailsVO, HttpStatus.OK);
    }


    @PostMapping(value = "/user/login")
    public ResponseEntity<UserAuthenticationOutputVO> signIn(@RequestBody UserAuthenticationInputVO userAuthenticationInputVO) throws Exception{
        System.out.println("starting of login");
        UserAuthenticationOutputVO userAuthenticationOutputVO = new UserAuthenticationOutputVO();
        System.out.println(userAuthenticationInputVO.getUserId() +" "+userAuthenticationInputVO.getPassword());
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userAuthenticationInputVO.getUserId(), userAuthenticationInputVO.getPassword()));
        System.out.println(authenticate.toString());
        System.out.println("is authentication done?");
        if(authenticate.isAuthenticated()){
            System.out.println("Account is authenticated");
            userAuthenticationOutputVO.setToken(jwtService.generateToken(userAuthenticationInputVO.getUserId()));
            System.out.println("JWT token is verfied: ");
            return new ResponseEntity<>(userAuthenticationOutputVO, HttpStatus.OK);
        }
        else
            throw new UsernameNotFoundException("bad credentials");
    }
}
