package com.banking.system.bank.authentication.mapper;

import com.banking.system.bank.authentication.vo.GetUserDetailsOutputVO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class GetSpecificUserDetailsMapper implements RowMapper {

    public GetUserDetailsOutputVO mapRow(ResultSet rs, int rowNum) throws SQLException {
        GetUserDetailsOutputVO getUserDetailsOutputVO = new GetUserDetailsOutputVO();
        getUserDetailsOutputVO.setUserId(rs.getString("user_id"));
        getUserDetailsOutputVO.setEmailAdd(rs.getString("email_add"));
        getUserDetailsOutputVO.setPassword(rs.getString("password"));
        getUserDetailsOutputVO.setRole(rs.getString("role"));
        getUserDetailsOutputVO.setPhoneNumber(rs.getString("ph_no"));
        getUserDetailsOutputVO.setIsLock(rs.getString("is_lock"));
        getUserDetailsOutputVO.setLastUpdate(rs.getString("last_update"));


        return getUserDetailsOutputVO;

    }
}
