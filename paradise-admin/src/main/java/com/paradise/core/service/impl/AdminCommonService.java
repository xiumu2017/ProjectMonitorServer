package com.paradise.core.service.impl;

import com.paradise.core.bo.AdminUserDetails;
import com.paradise.core.model.UmsAdmin;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AdminCommonService {
    public UmsAdmin getCurrentAdmin() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        AdminUserDetails details = (AdminUserDetails) authentication.getPrincipal();
        return details.getUmsAdmin();
    }
}
