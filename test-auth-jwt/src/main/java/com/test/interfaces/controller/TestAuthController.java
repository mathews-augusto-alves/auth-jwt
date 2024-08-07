package com.test.interfaces.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/test")
public class TestAuthController {

    @GetMapping("/user-auth/")
    @Secured("ROLE_USER")
    public ResponseEntity<?> testUserRole()  {
        return ResponseEntity.ok(null);
    }

    @GetMapping("/admin-auth/")
    @Secured("ROLE_ADMIN")
    public ResponseEntity<?> testAdminRoles()  {
        return ResponseEntity.ok(null);
    }
}
