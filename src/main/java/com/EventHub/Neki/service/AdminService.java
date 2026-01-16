package com.EventHub.Neki.service;

import com.EventHub.Neki.domain.Admin;
import com.EventHub.Neki.dto.CadastroDTO;
import com.EventHub.Neki.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void register(CadastroDTO data) {
        if (repository.findByEmail(data.getEmail()) != null) {
            throw new RuntimeException("Email já cadastrado!");
        }

        String encryptedPassword = passwordEncoder.encode(data.getSenha());

        Admin admin = new Admin();
        admin.setName(data.getNome());
        admin.setEmail(data.getEmail());
        admin.setPassword(encryptedPassword);
        repository.save(admin);
    }

    public Admin findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
    }
}