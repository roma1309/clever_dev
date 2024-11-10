package com.example.cleverdev.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "client_profile")
public class ClientProfileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(nullable = false)
    private String agency;
    @Column(name = "created_date_time")
    private LocalDateTime createdDateTime;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "clientProfileEntity")
    private List<ClientNoteEntity> clientNoteEntities = new ArrayList<>();

    public ClientProfileEntity(String firstName, String lastName, Status status, String agency) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
        this.agency = agency;
    }

    public ClientProfileEntity() {
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<ClientNoteEntity> getClientNoteEntities() {
        return clientNoteEntities;
    }

    public void setClientNoteEntities(List<ClientNoteEntity> clientNoteEntities) {
        this.clientNoteEntities = clientNoteEntities;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }
}
