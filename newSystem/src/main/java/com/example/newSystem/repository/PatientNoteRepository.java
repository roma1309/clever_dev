package com.example.newSystem.repository;

import com.example.newSystem.entity.PatientNoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientNoteRepository extends JpaRepository<PatientNoteEntity, Long> {
    public PatientNoteEntity findByOldNoteId(Long oldNoteId);
}
