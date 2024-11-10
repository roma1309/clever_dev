package com.example.cleverdev.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "old_company_user")
@Entity
public class OldCompanyUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String login;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "lastModifiedByUser")
     private List<ClientNoteEntity> clientModifiedNoteEntity = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "createdByUserId")
    private List<ClientNoteEntity> clientCreateNoteEntity  = new ArrayList<>();

    public OldCompanyUserEntity(String login) {
        this.login = login;
    }

    public OldCompanyUserEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<ClientNoteEntity> getClientModifiedNoteEntity() {
        return clientModifiedNoteEntity;
    }

    public void setClientModifiedNoteEntity(List<ClientNoteEntity> clientModifiedNoteEntity) {
        this.clientModifiedNoteEntity = clientModifiedNoteEntity;
    }

    public List<ClientNoteEntity> getClientCreateNoteEntity() {
        return clientCreateNoteEntity;
    }

    public void setClientCreateNoteEntity(List<ClientNoteEntity> clientCreateNoteEntity) {
        this.clientCreateNoteEntity = clientCreateNoteEntity;
    }
}
