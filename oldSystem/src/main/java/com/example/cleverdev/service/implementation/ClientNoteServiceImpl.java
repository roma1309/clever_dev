package com.example.cleverdev.service.implementation;

import com.example.cleverdev.dto.RequestNote;
import com.example.cleverdev.entity.ClientNoteEntity;
import com.example.cleverdev.repository.ClientNoteRepository;
import com.example.cleverdev.service.ClientNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientNoteServiceImpl implements ClientNoteService {
    private final ClientNoteRepository clientNoteRepo;

    @Autowired
    public ClientNoteServiceImpl(ClientNoteRepository clientNoteRepo) {
        this.clientNoteRepo = clientNoteRepo;
    }

    @Override
    public List<ClientNoteEntity> getNotes(RequestNote requestNote) {
        List<ClientNoteEntity> clientNoteEntityList = clientNoteRepo.searchNotes(requestNote.getAgency(),
                requestNote.getClientGuid());

        return clientNoteEntityList;
    }
}
