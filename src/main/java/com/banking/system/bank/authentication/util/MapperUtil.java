package com.banking.system.bank.authentication.util;

import com.banking.system.bank.authentication.dto.GetUserDetailsInputDTO;
import com.banking.system.bank.authentication.dto.GetUserDetailsOutputDTO;
import com.banking.system.bank.authentication.vo.GetUserDetailsInputVO;
import com.banking.system.bank.authentication.vo.GetUserDetailsOutputVO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapperUtil {
    public GetUserDetailsInputDTO getUserDetailsVOToDTO(GetUserDetailsInputVO getUserDetailsInputVO);
    public GetUserDetailsOutputVO getUserDetailsOutputDTOToVO(GetUserDetailsOutputDTO getUserDetailsOutputDTO);
    public List<GetUserDetailsOutputVO> getUsersDetailsOutputListDTOToVO(List<GetUserDetailsOutputDTO> getUserDetailsOutputDTOList);
}
