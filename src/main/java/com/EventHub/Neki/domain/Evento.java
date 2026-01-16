package com.EventHub.Neki.domain;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Table(name = "eventos", schema = "gerenciador")
@Entity(name = "eventos")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "event_date", nullable = false)
    private LocalDate date;

    @Column(name = "event_time", nullable = false)
    private LocalTime time;

    @Column(nullable = false)
    private String location;

    @Column(name = "image_url", columnDefinition = "TEXT")
    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id", nullable = false)
    private Admin admin;

    public Evento(Long id, String name, LocalDate date, LocalTime time, String location, String imageUrl, Admin admin) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.time = time;
        this.location = location;
        this.imageUrl = imageUrl;
        this.admin = admin;
    }

    public Evento() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}