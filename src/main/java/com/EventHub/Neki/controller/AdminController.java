package com.EventHub.Neki.controller;

import com.EventHub.Neki.domain.Admin;
import com.EventHub.Neki.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admins")
public class AdminController {

    @Autowired
    private AdminService service;

    @GetMapping("/{id}")
    public ResponseEntity<Admin> getUserById(@PathVariable Long id) {
        Admin admin = service.findById(id);
        return ResponseEntity.ok(admin);
    }
}