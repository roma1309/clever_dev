package com.example.newSystem.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "patient_profile")
@Entity
public class PatientProfileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "patientProfileEntity")
    private List<ClientGuidEntity> clientGuidEntityList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "patientProfileEntity")
    private List<PatientNoteEntity> patientNoteEntityList = new ArrayList<>();

    @Column(name = "status_id", nullable = false)
    private Integer statusId;

    public PatientProfileEntity() {
    }

    public PatientProfileEntity(String firstName, String lastName, Integer statusId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.statusId = statusId;
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


    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public List<ClientGuidEntity> getClientGuidEntityList() {
        return clientGuidEntityList;
    }

    public void setClientGuidEntityList(List<ClientGuidEntity> clientGuidEntityList) {
        this.clientGuidEntityList = clientGuidEntityList;
    }

    @Override
    public String toString() {
        return "PatientProfileEntity{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", clientGuidEntityList=" + clientGuidEntityList +
                ", patientNoteEntityList=" + patientNoteEntityList +
                ", statusId=" + statusId +
                '}';
    }
}
