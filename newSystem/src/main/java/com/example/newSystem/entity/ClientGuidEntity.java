package com.example.newSystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "old_client_id")
public class ClientGuidEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "client_id")
    private Long clientId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_profile_id")
    private PatientProfileEntity patientProfileEntity;


    public ClientGuidEntity(Long clientId, PatientProfileEntity patientProfileEntity) {
        this.clientId = clientId;
        this.patientProfileEntity = patientProfileEntity;
    }

    public ClientGuidEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public PatientProfileEntity getPatientProfileEntity() {
        return patientProfileEntity;
    }

    public void setPatientProfileEntity(PatientProfileEntity patientProfileEntity) {
        this.patientProfileEntity = patientProfileEntity;
    }

    @Override
    public String toString() {
        return "ClientGuidEntity{" +
                "id=" + id +
                ", clientId=" + clientId +

                '}';
    }
}
