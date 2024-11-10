package com.example.cleverdev.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "client_note")
public class ClientNoteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "created_date_time", nullable = false)
    private LocalDateTime createdDateTime;

    @Column(name = "last_modified_date_time", nullable = false)
    private LocalDateTime lastModifiedDateTime;
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_pat_note_to_client")
    private ClientProfileEntity clientProfileEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "last_modified_by_u")
    private OldCompanyUserEntity lastModifiedByUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by_user_id")
    private OldCompanyUserEntity createdByUserId;

    public ClientNoteEntity() {
    }

    public ClientNoteEntity(LocalDateTime createdDateTime,
                            LocalDateTime lastModifiedDateTime, String comment,
                            ClientProfileEntity clientProfileEntity, OldCompanyUserEntity lastModifiedByUser, OldCompanyUserEntity createdByUserId) {
        this.createdDateTime = createdDateTime;
        this.lastModifiedDateTime = lastModifiedDateTime;
        this.comment = comment;
        this.clientProfileEntity = clientProfileEntity;
        this.lastModifiedByUser = lastModifiedByUser;
        this.createdByUserId = createdByUserId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public LocalDateTime getLastModifiedDateTime() {
        return lastModifiedDateTime;
    }

    public void setLastModifiedDateTime(LocalDateTime lastModifiedDateTime) {
        this.lastModifiedDateTime = lastModifiedDateTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public ClientProfileEntity getClientProfileEntity() {
        return clientProfileEntity;
    }

    public void setClientProfileEntity(ClientProfileEntity clientProfileEntity) {
        this.clientProfileEntity = clientProfileEntity;
    }

    public OldCompanyUserEntity getLastModifiedByUser() {
        return lastModifiedByUser;
    }

    public void setLastModifiedByUser(OldCompanyUserEntity lastModifiedByUser) {
        this.lastModifiedByUser = lastModifiedByUser;
    }

    public OldCompanyUserEntity getCreatedByUserId() {
        return createdByUserId;
    }

    public void setCreatedByUserId(OldCompanyUserEntity createdByUserId) {
        this.createdByUserId = createdByUserId;
    }
}
