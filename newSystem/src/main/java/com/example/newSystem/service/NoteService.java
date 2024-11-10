package com.example.newSystem.service;

import com.example.newSystem.dto.ClientNoteDto;
import com.example.newSystem.entity.PatientNoteEntity;

public interface NoteService {
    public PatientNoteEntity createNote(ClientNoteDto clientNoteDto);
}
