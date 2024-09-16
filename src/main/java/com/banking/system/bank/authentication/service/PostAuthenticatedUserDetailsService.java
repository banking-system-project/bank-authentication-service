package com.banking.system.bank.authentication.service;

import com.banking.system.bank.authentication.vo.GetUserDetailsOutputVO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class PostAuthenticatedUserDetailsService implements UserDetails {

    private String userId;
    private String emailAdd;
    private String phoneNumber;
    private String password;
    private String role;
    private String isLock;
    private String lastUpdate;
    private List<GrantedAuthority> authorities;


    public PostAuthenticatedUserDetailsService(GetUserDetailsOutputVO userVO) {
        this.userId = userVO.getUserId();
        this.emailAdd = userVO.getEmailAdd();
        this.phoneNumber = userVO.getPhoneNumber();
        this.password = userVO.getPassword();
        this.role = userVO.getRole();
        this.isLock = userVO.getIsLock();
        this.lastUpdate = userVO.getLastUpdate();
        this.authorities = Arrays.stream(userVO.getRole().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.isLock.equals("No");
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.isLock.equals("No");
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.isLock.equals("No");
    }

    @Override
    public boolean isEnabled() {
        return this.isLock.equals("No");
    }

    public String getPhoneNo() {
        return phoneNumber;
    }

    public String getRoleAccess() {
        return role;
    }
}
