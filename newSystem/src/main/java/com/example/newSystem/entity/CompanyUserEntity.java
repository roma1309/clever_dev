package com.example.newSystem.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "company_user")
@Entity
public class CompanyUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String login;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "lastModifiedByUser")
    private List<PatientNoteEntity> patientNoteEntityList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "createdByUserId")
    private List<PatientNoteEntity> modifiedpatientNoteEntityList = new ArrayList<>();

    public CompanyUserEntity() {
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

    public List<PatientNoteEntity> getPatientNoteEntityList() {
        return patientNoteEntityList;
    }

    public void setPatientNoteEntityList(List<PatientNoteEntity> patientNoteEntityList) {
        this.patientNoteEntityList = patientNoteEntityList;
    }

    public List<PatientNoteEntity> getModifiedpatientNoteEntityList() {
        return modifiedpatientNoteEntityList;
    }

    public void setModifiedpatientNoteEntityList(List<PatientNoteEntity> modifiedpatientNoteEntityList) {
        this.modifiedpatientNoteEntityList = modifiedpatientNoteEntityList;
    }
}
