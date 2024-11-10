package com.example.newSystem.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Table(name = "patient_note")
@Entity
public class PatientNoteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "created_date_time", nullable = false)
    private LocalDateTime createdDateTime;

    @Column(name = "last_modified_date_time", nullable = false)
    private LocalDateTime lastModifiedDateTime;
    private String note;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_pat_note_to_client")
    private PatientProfileEntity patientProfileEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "last_modified_by_u")
    private CompanyUserEntity lastModifiedByUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by_user_id")
    private CompanyUserEntity createdByUserId;

    @Column(name = "old_note_id")
    private Long oldNoteId;

    public PatientNoteEntity() {
    }

    public Long getOldNoteId() {
        return oldNoteId;
    }

    public void setOldNoteId(Long oldNoteId) {
        this.oldNoteId = oldNoteId;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public PatientProfileEntity getPatientProfileEntity() {
        return patientProfileEntity;
    }

    public void setPatientProfileEntity(PatientProfileEntity patientProfileEntity) {
        this.patientProfileEntity = patientProfileEntity;
    }

    public CompanyUserEntity getLastModifiedByUser() {
        return lastModifiedByUser;
    }

    public void setLastModifiedByUser(CompanyUserEntity lastModifiedByUser) {
        this.lastModifiedByUser = lastModifiedByUser;
    }

    public CompanyUserEntity getCreatedByUserId() {
        return createdByUserId;
    }

    public void setCreatedByUserId(CompanyUserEntity createdByUserId) {
        this.createdByUserId = createdByUserId;
    }
}
