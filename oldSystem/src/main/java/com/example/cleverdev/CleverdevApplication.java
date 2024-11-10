package com.example.cleverdev;

import com.example.cleverdev.entity.ClientNoteEntity;
import com.example.cleverdev.entity.ClientProfileEntity;
import com.example.cleverdev.entity.OldCompanyUserEntity;
import com.example.cleverdev.entity.Status;
import com.example.cleverdev.repository.ClientNoteRepository;
import com.example.cleverdev.repository.ClientProfileRepository;
import com.example.cleverdev.repository.OldUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class CleverdevApplication implements CommandLineRunner {
    private final ClientNoteRepository clientNoteRepository;
    private final ClientProfileRepository clientProfileRepository;
    private final OldUserRepository oldUserRepository;

    @Autowired
    public CleverdevApplication(ClientNoteRepository clientNoteRepository, ClientProfileRepository clientProfileRepository, OldUserRepository oldUserRepository) {
        this.clientNoteRepository = clientNoteRepository;
        this.clientProfileRepository = clientProfileRepository;
        this.oldUserRepository = oldUserRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(CleverdevApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        OldCompanyUserEntity oldCompanyUserEntity1 = new OldCompanyUserEntity("user1");
        OldCompanyUserEntity oldCompanyUserEntity2 = new OldCompanyUserEntity("user2");
        OldCompanyUserEntity oldCompanyUserEntity3 = new OldCompanyUserEntity("user3");
        OldCompanyUserEntity oldCompanyUserEntity4 = new OldCompanyUserEntity("user4");

        ClientProfileEntity clientProfileEntity1 = new ClientProfileEntity("name1", "last_name1", Status.ACTIVE, "vvv1");
        ClientProfileEntity clientProfileEntity2 = new ClientProfileEntity("name2", "last_name2", Status.ACTIVE, "vvv2");
        ClientProfileEntity clientProfileEntity3 = new ClientProfileEntity("name3", "last_name3", Status.ACTIVE, "vvv3");
        ClientProfileEntity clientProfileEntity4 = new ClientProfileEntity("name4", "last_name4", Status.ACTIVE, "vvv4");
        ClientProfileEntity clientProfileEntity5 = new ClientProfileEntity("name5", "last_name5", Status.ACTIVE, "vvv5");



        try {
            oldUserRepository.save(oldCompanyUserEntity1);
            oldUserRepository.save(oldCompanyUserEntity2);
            oldUserRepository.save(oldCompanyUserEntity3);
            oldUserRepository.save(oldCompanyUserEntity4);

            clientProfileRepository.save(clientProfileEntity1);
            clientProfileRepository.save(clientProfileEntity2);
            clientProfileRepository.save(clientProfileEntity3);
            clientProfileRepository.save(clientProfileEntity4);
            clientProfileRepository.save(clientProfileEntity5);
        } catch (RuntimeException e) {

        }

        ClientNoteEntity clientNoteEntity1 = new ClientNoteEntity(LocalDateTime.now(), LocalDateTime.now(), " comment1", clientProfileEntity2, oldCompanyUserEntity1, oldCompanyUserEntity1);
        ClientNoteEntity clientNoteEntity2 = new ClientNoteEntity(LocalDateTime.now(), LocalDateTime.now(), " comment2", clientProfileEntity3, oldCompanyUserEntity2, oldCompanyUserEntity2);
        ClientNoteEntity clientNoteEntity3 = new ClientNoteEntity(LocalDateTime.now(), LocalDateTime.of(2025,6,13,12,55), " comment3", clientProfileEntity1, oldCompanyUserEntity2, oldCompanyUserEntity1);
        ClientNoteEntity clientNoteEntity4 = new ClientNoteEntity(LocalDateTime.now(), LocalDateTime.of(2024,11,28,15,55), " comment4", clientProfileEntity2, oldCompanyUserEntity4, oldCompanyUserEntity3);
        ClientNoteEntity clientNoteEntity5 = new ClientNoteEntity(LocalDateTime.now(), LocalDateTime.of(2025,8,13,14,55), " comment5", clientProfileEntity1, oldCompanyUserEntity4, oldCompanyUserEntity2);
        ClientNoteEntity clientNoteEntity6 = new ClientNoteEntity(LocalDateTime.now(), LocalDateTime.of(2025,1,19,5,55), " comment6", clientProfileEntity5, oldCompanyUserEntity1, oldCompanyUserEntity4);
        ClientNoteEntity clientNoteEntity7 = new ClientNoteEntity(LocalDateTime.now(), LocalDateTime.now(), " comment7", clientProfileEntity5, oldCompanyUserEntity2, oldCompanyUserEntity2);
        ClientNoteEntity clientNoteEntity8 = new ClientNoteEntity(LocalDateTime.now(), LocalDateTime.now(), " comment8", clientProfileEntity2, oldCompanyUserEntity4, oldCompanyUserEntity4);
        ClientNoteEntity clientNoteEntity9 = new ClientNoteEntity(LocalDateTime.now(), LocalDateTime.of(2028,6,7,12,55), " comment9", clientProfileEntity3, oldCompanyUserEntity1, oldCompanyUserEntity3);
//
//        clientNoteRepository.save(clientNoteEntity1);
//        clientNoteRepository.save(clientNoteEntity2);
//        clientNoteRepository.save(clientNoteEntity3);
//        clientNoteRepository.save(clientNoteEntity4);
//        clientNoteRepository.save(clientNoteEntity5);
//        clientNoteRepository.save(clientNoteEntity6);
//        clientNoteRepository.save(clientNoteEntity7);
//        clientNoteRepository.save(clientNoteEntity8);
//        clientNoteRepository.save(clientNoteEntity9);

        try {
            clientNoteRepository.save(clientNoteEntity1);
            clientNoteRepository.save(clientNoteEntity2);
            clientNoteRepository.save(clientNoteEntity3);
            clientNoteRepository.save(clientNoteEntity4);
            clientNoteRepository.save(clientNoteEntity5);
            clientNoteRepository.save(clientNoteEntity6);
            clientNoteRepository.save(clientNoteEntity7);
            clientNoteRepository.save(clientNoteEntity8);
            clientNoteRepository.save(clientNoteEntity9);
        }catch (RuntimeException e){

        }

    }
}
