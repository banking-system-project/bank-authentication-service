package com.banking.system.bank.authentication.controller;

import com.banking.system.bank.authentication.config.HeaderInterceptor;
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

    @Autowired
    private HeaderInterceptor headerInterceptor;

    @PostMapping(value = "/user/register")
    public ResponseEntity<RegisterUserOutputVO> registerUser(@RequestBody RegisterUserInputVO registerUserInputVO){
        RegisterUserOutputVO registerUserOutputVO = authenticationService.registerUser(registerUserInputVO);
        return new ResponseEntity<>(registerUserOutputVO, HttpStatus.OK);
    }

    @PostMapping(value = "/user/details")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity<Object> getUsers(){
        List<GetUserDetailsLimitedOutputVO> getUserOutputDetailsVO = authenticationService.getUserDetails();
        return new ResponseEntity<>(getUserOutputDetailsVO, HttpStatus.OK);
    }

    @PostMapping(value = "/user/login")
    public ResponseEntity<UserAuthenticationOutputVO> signIn(@RequestBody UserAuthenticationInputVO userAuthenticationInputVO) throws Exception{
        UserAuthenticationOutputVO userAuthenticationOutputVO = new UserAuthenticationOutputVO();
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userAuthenticationInputVO.getUserId(), userAuthenticationInputVO.getPassword()));
        if(authenticate.isAuthenticated()){
            userAuthenticationOutputVO.setToken(jwtService.generateToken(userAuthenticationInputVO.getUserId()));
            return new ResponseEntity<>(userAuthenticationOutputVO, HttpStatus.OK);
        }
        else
            throw new UsernameNotFoundException("bad credentials");
    }

    @PutMapping(value = "/user/update/password")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity<UpdateDetailsOutputVO> userPasswordUpdate(@RequestBody UpdatePasswordInputVO updatePasswordInputVO){
        System.out.println("here");
        String userName = headerInterceptor.getUsername();
        System.out.println(userName);
        UpdateDetailsOutputVO updateDetailsOutputVO = authenticationService.updatePassword(updatePasswordInputVO,userName);
        return new ResponseEntity<>(updateDetailsOutputVO, HttpStatus.OK);
    }

    @GetMapping("/token")
    public String validateToken(@RequestParam("token") String token){
        try{
            jwtService.verifyToken(token);
        }catch (RuntimeException re){
            System.out.println("token is invalid");
        }
        return "valid";
    }
}
