package com.example.newSystem.service.implementation;

import com.example.newSystem.config.UrlConstant;
import com.example.newSystem.dto.ClientNoteDto;
import com.example.newSystem.entity.ClientGuidEntity;
import com.example.newSystem.entity.CompanyUserEntity;
import com.example.newSystem.entity.PatientNoteEntity;
import com.example.newSystem.entity.PatientProfileEntity;
import com.example.newSystem.repository.ClientGuidRepository;
import com.example.newSystem.repository.CompanyUserRepository;
import com.example.newSystem.repository.PatientNoteRepository;
import com.example.newSystem.repository.PatientProfileRepository;
import com.example.newSystem.service.NoteService;
import com.example.newSystem.web.controller.ImportSystem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatientNoteServiceImpl implements NoteService {
    public static final Logger LOG = LoggerFactory.getLogger(PatientNoteServiceImpl.class);
    private final List<Integer> status = List.of(200, 210, 230);
    private final PatientNoteRepository patientNoteRepo;
    private final PatientProfileRepository patientProfileRepo;
    private final ClientGuidRepository clientGuidRepo;
    private final CompanyUserRepository companyUserRepo;

    @Autowired
    public PatientNoteServiceImpl(PatientNoteRepository patientNoteRepo, PatientProfileRepository patientProfileRepo, ClientGuidRepository clientGuidRepo, CompanyUserRepository companyUserRepo) {
        this.patientNoteRepo = patientNoteRepo;
        this.patientProfileRepo = patientProfileRepo;
        this.clientGuidRepo = clientGuidRepo;
        this.companyUserRepo = companyUserRepo;
    }

    @Override
    @Transactional
    public PatientNoteEntity createNote(ClientNoteDto clientNoteDto) {
        List<PatientProfileEntity> patientProfileList = getPatient(clientNoteDto.getClientGuid());
        for (PatientProfileEntity patientProfileEntity : patientProfileList) {
            if (status.contains(patientProfileEntity.getStatusId())) {
                CompanyUserEntity companyUserEntity = getUser(clientNoteDto.getLoggedUser());
                if (companyUserEntity == null) {
                    companyUserEntity = createUser(clientNoteDto.getLoggedUser());
                    LOG.info("create user {}", companyUserEntity.getLogin());
                }
                PatientNoteEntity patientNoteEntity = getPatientNote(clientNoteDto.getId());
                if (patientNoteEntity != null && clientNoteDto.getModifiedDateTime().isAfter(patientNoteEntity.getLastModifiedDateTime())) {
                    patientNoteEntity.setNote(clientNoteDto.getComments());
                    patientNoteEntity.setLastModifiedDateTime(clientNoteDto.getModifiedDateTime());
                    patientNoteEntity.setLastModifiedByUser(companyUserEntity);
                    LOG.info("The note has been updated {}", patientNoteEntity.getNote());
                    return patientNoteRepo.save(patientNoteEntity);
                } else if (patientNoteEntity == null) {
                    PatientNoteEntity newPatientNoteEntity = new PatientNoteEntity();
                    newPatientNoteEntity.setCreatedDateTime(clientNoteDto.getDateTime());
                    newPatientNoteEntity.setLastModifiedDateTime(clientNoteDto.getModifiedDateTime());
                    newPatientNoteEntity.setNote(clientNoteDto.getComments());
                    newPatientNoteEntity.setOldNoteId(clientNoteDto.getId());
                    newPatientNoteEntity.setCreatedByUserId(companyUserEntity);
                    newPatientNoteEntity.setLastModifiedByUser(companyUserEntity);
                    newPatientNoteEntity.setPatientProfileEntity(patientProfileEntity);
                    LOG.info("The note has been created {}", newPatientNoteEntity.getNote());
                    return patientNoteRepo.save(newPatientNoteEntity);
                }
            }

        }
        if (patientProfileList.size() == 0) {
            LOG.info("no matches of clients and patients were found with id {}", clientNoteDto.getClientGuid());
        }
            return null;
    }


    private List<PatientProfileEntity> getPatient(Long clientId) {
        List<ClientGuidEntity> clientGuidEntityList = clientGuidRepo.findByClientId(clientId);
//        System.out.println(clientGuidEntityList.toString());
//        System.out.println(clientId);
        return clientGuidEntityList.stream()
                .map(ClientGuidEntity::getPatientProfileEntity).collect(Collectors.toList());

    }

    private PatientNoteEntity getPatientNote(Long noteId) {
        return patientNoteRepo.findByOldNoteId(noteId);
    }

    private CompanyUserEntity getUser(String login) {
        return companyUserRepo.findByLogin(login);
    }

    private CompanyUserEntity createUser(String login) {
        CompanyUserEntity companyUserEntity = new CompanyUserEntity();
        companyUserEntity.setLogin(login);
        return companyUserRepo.save(companyUserEntity);
    }
}
