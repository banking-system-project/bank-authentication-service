package com.banking.system.bank.authentication.dao;

import com.banking.system.bank.authentication.dto.GetUserDetailsOutputDTO;
import com.banking.system.bank.authentication.mapper.GetUserDetailsOutputMapper;
import com.banking.system.bank.authentication.util.SqlQueriesContstant;
import com.banking.system.bank.authentication.vo.GetUserDetailsOutputVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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

    public Optional<GetUserDetailsOutputVO> getUserDetailByUserNameAndPassWord(String userName){
        GetUserDetailsOutputVO getUserDetailsOutputVO = new GetUserDetailsOutputVO();
        try{
            getUserDetailsOutputVO = (GetUserDetailsOutputVO) jdbcTemplate.queryForObject(SqlQueriesContstant.SQL_GET_USER_DETAILS_BY_USERNAME_PASSWORD, getUserDetailsOutputMapper, new Object[]{userName});
        }catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
        return Optional.ofNullable(getUserDetailsOutputVO);
    }
}
