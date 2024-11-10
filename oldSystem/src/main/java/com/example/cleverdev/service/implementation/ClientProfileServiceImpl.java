package com.example.cleverdev.service.implementation;

import com.example.cleverdev.entity.ClientProfileEntity;
import com.example.cleverdev.repository.ClientProfileRepository;
import com.example.cleverdev.service.ClientProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientProfileServiceImpl implements ClientProfileService {
    private final ClientProfileRepository clientProfileRepo;

    @Autowired
    public ClientProfileServiceImpl(ClientProfileRepository clientProfileRepo) {
        this.clientProfileRepo = clientProfileRepo;
    }

    @Override
    public List<ClientProfileEntity> getClients() {
        return clientProfileRepo.findAll();
    }
}
