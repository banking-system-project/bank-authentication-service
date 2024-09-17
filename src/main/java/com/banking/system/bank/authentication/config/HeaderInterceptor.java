package com.banking.system.bank.authentication.config;

import com.banking.system.bank.authentication.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Objects;

@Component
public class HeaderInterceptor{
    private static final String AUTHORIZATION_HEADER = "Authorization";

    @Autowired
    private JwtService jwtService;

    public static String getBearerTokenHeader() {
        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest().getHeader(AUTHORIZATION_HEADER);
    }

    public String getUsername() {
        String token = null;
        String userId = null;
        String authHeader = getBearerTokenHeader();
        try {
            if (authHeader != null && authHeader.startsWith("Bearer ")) {
                token = authHeader.substring(7);
                userId = jwtService.extractUsername(token);
                return userId;
            } else {
                throw new RuntimeException("Something went wrong !!");
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

    }
}
