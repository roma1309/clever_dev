package com.example.cleverdev.converter;

import com.example.cleverdev.dto.old.NoteDto;
import com.example.cleverdev.entity.ClientNoteEntity;

public class NoteConverter {
    public static NoteDto entityToDto(ClientNoteEntity clientNoteEntity) {
        NoteDto noteDto = new NoteDto();
        noteDto.setComments(clientNoteEntity.getComment());
        noteDto.setDateTime(clientNoteEntity.getCreatedDateTime());
        noteDto.setModifiedDateTime(clientNoteEntity.getLastModifiedDateTime());
        noteDto.setLoggedUser(clientNoteEntity.getCreatedByUserId().getLogin());
        noteDto.setClientGuid(clientNoteEntity.getClientProfileEntity().getId());
        noteDto.setId(clientNoteEntity.getId());
        return noteDto;
    }
}
