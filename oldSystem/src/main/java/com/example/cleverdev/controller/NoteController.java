package com.example.cleverdev.controller;

import com.example.cleverdev.converter.ClientProfileConverter;
import com.example.cleverdev.converter.NoteConverter;
import com.example.cleverdev.dto.RequestNote;
import com.example.cleverdev.dto.old.NoteDto;
import com.example.cleverdev.service.ClientNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class NoteController {
    private final ClientNoteService clientNoteService;

    @Autowired
    public NoteController(ClientNoteService clientNoteService) {
        this.clientNoteService = clientNoteService;
    }

    @PostMapping("/notes")
    public ResponseEntity<List<NoteDto>> getNotes(@RequestBody RequestNote requestNote) {
        List<NoteDto> noteDtoList = clientNoteService.getNotes(requestNote)
                .stream().map(NoteConverter::entityToDto).collect(Collectors.toList());
        return new ResponseEntity<>(noteDtoList, HttpStatus.OK);
    }
}
