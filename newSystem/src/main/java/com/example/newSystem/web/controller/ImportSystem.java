package com.example.newSystem.web.controller;

import com.example.newSystem.config.UrlConstant;
import com.example.newSystem.dto.ClientDto;
import com.example.newSystem.dto.ClientNoteDto;
import com.example.newSystem.dto.RequestForGetNotes;
import com.example.newSystem.entity.PatientNoteEntity;
import com.example.newSystem.exceptions.RestTemplateException;
import com.example.newSystem.service.NoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ImportSystem {
    private final RestTemplate restTemplate;
    private final NoteService noteService;

    public static final Logger LOG = LoggerFactory.getLogger(ImportSystem.class);

    @Autowired
    public ImportSystem(RestTemplate restTemplate, NoteService noteService) {
        this.restTemplate = restTemplate;
        this.noteService = noteService;
    }

    public List<ClientDto> getClients() {
        try {
            ResponseEntity<List<ClientDto>> clientDto = restTemplate.exchange(UrlConstant.CLIENTS,
                    HttpMethod.POST, null, new ParameterizedTypeReference<List<ClientDto>>() {
                    });
            return clientDto.getBody();

        } catch (Exception e) {
            LOG.error("Server not found to path url: {}", UrlConstant.CLIENTS);
            throw new RestTemplateException("error");
        }

    }

    @Scheduled(fixedDelay = 50000)
    public void updateNotes() {
        List<ClientDto> clientDtoList = new ArrayList<>();
        try {
            clientDtoList = getClients();
        } catch (RestTemplateException e) {
            LOG.error("Server not found to path url: {}", UrlConstant.CLIENTS);
        }

        for (ClientDto clientDto : clientDtoList) {
            RequestForGetNotes requestForGetNotes = new RequestForGetNotes();
            requestForGetNotes.setAgency(clientDto.getAgency());
            requestForGetNotes.setClientGuid(clientDto.getGuId());
            HttpEntity<RequestForGetNotes> requestEntity = new HttpEntity<>(requestForGetNotes);
            try {
                ResponseEntity<List<ClientNoteDto>> clientNoteDtoList = restTemplate.exchange(UrlConstant.NOTES, HttpMethod.POST,
                        requestEntity, new ParameterizedTypeReference<List<ClientNoteDto>>() {
                        });
                for (ClientNoteDto clientNoteDto : clientNoteDtoList.getBody()) {
                    noteService.createNote(clientNoteDto);
                }
            } catch (Exception e) {
                LOG.error("Server not found to path url: {}", UrlConstant.NOTES);
            }
        }
    }
}
