package com.example.newSystem.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class RequestForGetNotes {
    private String agency;
    private Long clientGuid;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime dateFrom;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime dateTo;

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

    public LocalDateTime getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDateTime dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDateTime getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDateTime dateTo) {
        this.dateTo = dateTo;
    }
}
