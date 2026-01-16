package com.EventHub.Neki.service;

import com.EventHub.Neki.domain.Evento;
import com.EventHub.Neki.domain.Admin;
import com.EventHub.Neki.dto.EventoDTO;
import com.EventHub.Neki.repository.AdminRepository;
import com.EventHub.Neki.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {

    @Autowired
    private EventoRepository repository;

    @Autowired
    private AdminRepository adminRepository;

    private Admin getAdminLogado() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return adminRepository.findByEmail(email);
    }

    public List<Evento> listar() {
        Admin admin = getAdminLogado();
        return repository.findByAdmin(admin);
    }

    public Evento criar(EventoDTO dto) {
        Admin admin = getAdminLogado();
        Evento evento = new Evento();
        evento.setName(dto.getName());
        evento.setDate(dto.getDate());
        evento.setTime(dto.getTime());
        evento.setLocation(dto.getLocation());
        evento.setImageUrl(dto.getImageUrl());
        evento.setAdmin(admin);

        return repository.save(evento);
    }

    public Evento atualizar(Long id, EventoDTO dto) {
        Evento evento = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evento não encontrado"));

        if (dto.getName() != null) evento.setName(dto.getName());
        if (dto.getDate() != null) evento.setDate(dto.getDate());
        if (dto.getTime() != null) evento.setTime(dto.getTime());
        if (dto.getLocation() != null) evento.setLocation(dto.getLocation());
        if (dto.getImageUrl() != null) evento.setImageUrl(dto.getImageUrl());

        return repository.save(evento);
    }

    public void deletar(Long id) {
        Evento evento = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evento não encontrado"));
        repository.delete(evento);
    }
}