package com.example.newSystem.repository;

import com.example.newSystem.entity.PatientProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientProfileRepository extends JpaRepository<PatientProfileEntity,Long> {

}
