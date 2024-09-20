package com.banking.system.bank.authentication.dao;

import com.banking.system.bank.authentication.dto.GetUserDetailsOutputDTO;
import com.banking.system.bank.authentication.mapper.GetSpecificUserDetailsMapper;
import com.banking.system.bank.authentication.mapper.GetUserDetailsOutputMapper;
import com.banking.system.bank.authentication.util.SqlQueriesContstant;
import com.banking.system.bank.authentication.vo.GetUserDetailsOutputVO;
import com.banking.system.bank.authentication.vo.UpdateDetailsOutputVO;
import com.banking.system.bank.authentication.vo.UpdatePasswordInputVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Repository
public class AuthenticationDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private GetUserDetailsOutputMapper getUserDetailsOutputMapper;

    @Autowired
    private GetSpecificUserDetailsMapper getSpecificUserDetailsMapper;

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
        GetUserDetailsOutputVO getUserDetailsOutputVO = null;
        try{
            getUserDetailsOutputVO = (GetUserDetailsOutputVO) jdbcTemplate.queryForObject(SqlQueriesContstant.SQL_GET_USER_DETAILS_BY_USERNAME_PASSWORD, new Object[]{userName},getSpecificUserDetailsMapper);
        }catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
        return Optional.ofNullable(getUserDetailsOutputVO);
    }

    public UpdateDetailsOutputVO updateUserPassword(String hashedPassword, String userName) {
        UpdateDetailsOutputVO updateDetailsOutputVO = new UpdateDetailsOutputVO();

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String currentTimeStamp = now.format(formatter);

        int result=0;
        try{
            result = jdbcTemplate.update(SqlQueriesContstant.UPDATE_PASSWORD, new Object[]{hashedPassword, currentTimeStamp, userName});

            if(result == 1){
                updateDetailsOutputVO.setUpdateMessage("user Password updated successfully");
            }
            else {
                updateDetailsOutputVO.setUpdateMessage("Something Wrong!!");
            }

        }catch (Exception e) {
            updateDetailsOutputVO.setUpdateMessage(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
        return updateDetailsOutputVO;
    }

    public UpdateDetailsOutputVO updateUserEmail(String newEmail, String userName) {
        UpdateDetailsOutputVO updateDetailsOutputVO = new UpdateDetailsOutputVO();

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String currentTimeStamp = now.format(formatter);

        int result=0;
        try{
            result = jdbcTemplate.update(SqlQueriesContstant.EMAIL_UPDATE, new Object[]{newEmail, currentTimeStamp, userName});

            if(result == 1){
                updateDetailsOutputVO.setUpdateMessage("user Email details updated successfully");
            }
            else {
                updateDetailsOutputVO.setUpdateMessage("Something Wrong!!");
            }

        }catch (Exception e) {
            updateDetailsOutputVO.setUpdateMessage(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
        return updateDetailsOutputVO;
    }

    public UpdateDetailsOutputVO updateUserPhone(String phone, String userName) {
        UpdateDetailsOutputVO updateDetailsOutputVO = new UpdateDetailsOutputVO();

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String currentTimeStamp = now.format(formatter);

        int result=0;
        try{
            result = jdbcTemplate.update(SqlQueriesContstant.PHONE_UPDATE, new Object[]{phone, currentTimeStamp, userName});

            if(result == 1){
                updateDetailsOutputVO.setUpdateMessage("user Phone number details updated successfully");
            }
            else {
                updateDetailsOutputVO.setUpdateMessage("Something Wrong!!");
            }

        }catch (Exception e) {
            updateDetailsOutputVO.setUpdateMessage(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
        return updateDetailsOutputVO;
    }
}
