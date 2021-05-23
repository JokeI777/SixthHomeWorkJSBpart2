package com.example.demo;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableGlobalMethodSecurity(securedEnabled = true)
public class APIs extends GlobalMethodSecurityConfiguration {

    @GetMapping("public/api")
    public String publicApi(){
        return "public";
    }

    @Secured("admin")
    @GetMapping("private/admin/api")
    public String adminApi(){
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return "Name: " + securityContext.getAuthentication().getName() + "; " + "Role: admin";
    }

    @Secured("support")
    @GetMapping("private/support/api")
    public String supportApi(){
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return "Name: " + securityContext.getAuthentication().getName() + "; " + "Role: support";
    }
}
