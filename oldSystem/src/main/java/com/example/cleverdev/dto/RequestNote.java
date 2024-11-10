package com.example.cleverdev.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class RequestNote {
    private String agency;
    private Long clientGuid;

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public Long getClientGuid() {
        return clientGuid;
    }

    public void setClientGuid(Long clientGuid) {
        this.clientGuid = clientGuid;
    }
}
