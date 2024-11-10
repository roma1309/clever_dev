package com.example.cleverdev.converter;

import com.example.cleverdev.dto.old.ClientDto;
import com.example.cleverdev.entity.ClientProfileEntity;

public class ClientProfileConverter {

    public static ClientDto entityToDto(ClientProfileEntity clientProfileEntity) {
        ClientDto clientDto = new ClientDto();
        clientDto.setFirstName(clientProfileEntity.getFirstName());
        clientDto.setLastName(clientProfileEntity.getLastName());
        clientDto.setStatus(clientProfileEntity.getStatus().name());
        clientDto.setAgency(clientProfileEntity.getAgency());
        clientDto.setCreatedDateTime(clientProfileEntity.getCreatedDateTime());
        clientDto.setGuId(clientProfileEntity.getId());
        return clientDto;
    }
}
