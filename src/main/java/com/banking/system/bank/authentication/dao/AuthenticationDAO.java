package com.banking.system.bank.authentication.dao;

import com.banking.system.bank.authentication.dto.GetUserDetailsInputDTO;
import com.banking.system.bank.authentication.dto.GetUserDetailsOutputDTO;
import com.banking.system.bank.authentication.mapper.GetUserDetailsOutputMapper;
import com.banking.system.bank.authentication.util.SqlQueriesContstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthenticationDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private GetUserDetailsOutputMapper getUserDetailsOutputMapper;

    public List<GetUserDetailsOutputDTO> getUserDetails(){
        List<GetUserDetailsOutputDTO> getUserDetailsOutputDTO = null;
        try{
            getUserDetailsOutputDTO = (List<GetUserDetailsOutputDTO>) jdbcTemplate.query(SqlQueriesContstant.SQL_GET_USER_DETAILS,getUserDetailsOutputMapper);
        }catch(Exception e){
            e.printStackTrace();
        }
        return getUserDetailsOutputDTO;
    }
}
