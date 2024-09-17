package com.banking.system.bank.authentication.util;

import com.banking.system.bank.authentication.dto.GetUserDetailsInputDTO;
import com.banking.system.bank.authentication.dto.GetUserDetailsOutputDTO;
import com.banking.system.bank.authentication.vo.GetUserDetailsInputVO;
import com.banking.system.bank.authentication.vo.GetUserDetailsLimitedOutputVO;
import com.banking.system.bank.authentication.vo.GetUserDetailsOutputVO;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface MapperUtil {
    public GetUserDetailsInputDTO getUserDetailsVOToDTO(GetUserDetailsInputVO getUserDetailsInputVO);
    public GetUserDetailsOutputVO getUserDetailsOutputDTOToVO(GetUserDetailsOutputDTO getUserDetailsOutputDTO);
    public List<GetUserDetailsOutputVO> getUsersDetailsOutputListDTOToVO(List<GetUserDetailsOutputDTO> getUserDetailsOutputDTOList);

    default List<GetUserDetailsLimitedOutputVO> getUsersLimitedDetailsOutputListDTOToVO(List<GetUserDetailsOutputDTO> getUserDetailsOutputDTOList){
        List<GetUserDetailsLimitedOutputVO> limitedData = new ArrayList<GetUserDetailsLimitedOutputVO>();
        for(GetUserDetailsOutputDTO getUserDetailsOutputDTO : getUserDetailsOutputDTOList){
            GetUserDetailsLimitedOutputVO getUserDetailsLimitedOutputVO = new GetUserDetailsLimitedOutputVO();
            getUserDetailsLimitedOutputVO.setUserId(getUserDetailsOutputDTO.getUserId());
            getUserDetailsLimitedOutputVO.setEmailAdd(getUserDetailsOutputDTO.getEmailAdd());
            getUserDetailsLimitedOutputVO.setRole(getUserDetailsOutputDTO.getRole());
            getUserDetailsLimitedOutputVO.setPhoneNumber(getUserDetailsOutputDTO.getPhoneNumber());
            getUserDetailsLimitedOutputVO.setLastUpdate(getUserDetailsOutputDTO.getLastUpdate());
            limitedData.add(getUserDetailsLimitedOutputVO);
        }
        return limitedData;
    }
}
