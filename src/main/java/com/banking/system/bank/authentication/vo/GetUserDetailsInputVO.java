package com.banking.system.bank.authentication.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetUserDetailsInputVO {

    @Id
    private String userId;

}
