package com.EventHub.Neki.controller;

import com.EventHub.Neki.dto.CadastroDTO;
import com.EventHub.Neki.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody CadastroDTO data) {
        adminService.register(data);
        return ResponseEntity.ok("Usuário cadastrado com sucesso!");
    }
}