package com.example.cleverdev.service;

import com.example.cleverdev.dto.RequestNote;
import com.example.cleverdev.entity.ClientNoteEntity;

import java.util.List;

public interface ClientNoteService {
    public List<ClientNoteEntity> getNotes(RequestNote requestNote);
}
