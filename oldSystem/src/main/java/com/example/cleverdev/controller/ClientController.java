package com.example.cleverdev.controller;

import com.example.cleverdev.converter.ClientProfileConverter;
import com.example.cleverdev.dto.old.ClientDto;
import com.example.cleverdev.service.ClientProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ClientController {
    private final ClientProfileService clientProfileService;

    @Autowired
    public ClientController(ClientProfileService clientProfileService) {
        this.clientProfileService = clientProfileService;
    }

    @PostMapping("/clients")
    public ResponseEntity<List<ClientDto>> getClients() {
        List<ClientDto> clientDtoList = clientProfileService.getClients()
                .stream().map(ClientProfileConverter::entityToDto).collect(Collectors.toList());
        return new ResponseEntity<>(clientDtoList, HttpStatus.OK);
    }

}
