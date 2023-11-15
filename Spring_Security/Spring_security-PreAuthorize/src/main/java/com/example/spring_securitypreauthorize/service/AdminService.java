package com.example.spring_securitypreauthorize.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void doAdminStaff(){
        System.out.println("зашел админ");
    }
}
