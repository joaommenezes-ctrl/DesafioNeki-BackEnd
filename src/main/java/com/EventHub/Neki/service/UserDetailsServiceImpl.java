package com.EventHub.Neki.service;

import com.EventHub.Neki.domain.Admin;
import com.EventHub.Neki.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AdminRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Admin admin = repository.findByEmail(email);
        if (admin == null) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }

        return admin;
    }
}