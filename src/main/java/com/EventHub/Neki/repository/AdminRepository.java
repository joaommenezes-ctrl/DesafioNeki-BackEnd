package com.EventHub.Neki.repository;

import com.EventHub.Neki.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface AdminRepository  extends JpaRepository<Admin, Long> {

    Admin findByEmail (String email);

    boolean existsByEmail(String email);
    
}
