package com.banking.system.bank.authentication.mapper;


import com.banking.system.bank.authentication.dto.GetUserDetailsOutputDTO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class GetUserDetailsOutputMapper implements RowMapper {

    public GetUserDetailsOutputDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        GetUserDetailsOutputDTO getUserDetailsOutputDTO = new GetUserDetailsOutputDTO();
        getUserDetailsOutputDTO.setUserId(rs.getString("user_id"));
        getUserDetailsOutputDTO.setEmailAdd(rs.getString("email_add"));
        getUserDetailsOutputDTO.setPhoneNumber(rs.getString("ph_no"));
        getUserDetailsOutputDTO.setPassword(rs.getString("password"));
        getUserDetailsOutputDTO.setRole(rs.getString("role"));
        getUserDetailsOutputDTO.setIsLock(rs.getString("is_lock"));
        getUserDetailsOutputDTO.setCreatedAt(rs.getString("created_at"));
        getUserDetailsOutputDTO.setLastUpdate(rs.getString("last_update"));

        return getUserDetailsOutputDTO;

    }
}
