package com.EventHub.Neki.controller;

import com.EventHub.Neki.domain.Evento;
import com.EventHub.Neki.dto.EventoDTO;
import com.EventHub.Neki.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoService service;

    @GetMapping("/listar")
    public ResponseEntity<List<Evento>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @PostMapping("/criar")
    public ResponseEntity<Evento> criar(@RequestBody EventoDTO dto) {
        return ResponseEntity.ok(service.criar(dto));
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Evento> atualizar(@PathVariable Long id, @RequestBody EventoDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}