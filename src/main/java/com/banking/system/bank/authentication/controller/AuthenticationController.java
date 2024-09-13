package com.banking.system.bank.authentication.controller;

import com.banking.system.bank.authentication.service.AuthenticationService;
import com.banking.system.bank.authentication.service.AuthenticationServiceImpl;
import com.banking.system.bank.authentication.vo.GetUserDetailsInputVO;
import com.banking.system.bank.authentication.vo.GetUserDetailsOutputVO;
import com.banking.system.bank.authentication.vo.RegisterUserInputVO;
import com.banking.system.bank.authentication.vo.RegisterUserOutputVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank/authentication")
public class AuthenticationController {

    @Autowired
    AuthenticationServiceImpl authenticationService;

    @PostMapping(value = "/user/register")
    public ResponseEntity<RegisterUserOutputVO> registerUser(@RequestBody RegisterUserInputVO registerUserInputVO){
        RegisterUserOutputVO registerUserOutputVO = authenticationService.registerUser(registerUserInputVO);
        return new ResponseEntity<>(registerUserOutputVO, HttpStatus.OK);
    }
    @PostMapping(value = "/user/details")
    public ResponseEntity<Object> getUsers(){
        List<GetUserDetailsOutputVO> getUserOutputDetailsVO = authenticationService.getUserDetails();
        return new ResponseEntity<>(getUserOutputDetailsVO, HttpStatus.OK);
    }
}
