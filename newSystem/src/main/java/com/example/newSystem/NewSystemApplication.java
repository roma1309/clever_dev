package com.example.newSystem;

import com.example.newSystem.entity.ClientGuidEntity;
import com.example.newSystem.entity.PatientProfileEntity;
import com.example.newSystem.repository.ClientGuidRepository;
import com.example.newSystem.repository.PatientNoteRepository;
import com.example.newSystem.repository.PatientProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Optional;

@SpringBootApplication
@EnableScheduling
public class NewSystemApplication implements CommandLineRunner {
    private final PatientNoteRepository patientNoteRepo;
    private final PatientProfileRepository patientProfileRepository;
    private final ClientGuidRepository clientGuidRepo;

    @Autowired
    public NewSystemApplication(PatientNoteRepository patientNoteRepo, PatientProfileRepository patientProfileRepository, ClientGuidRepository clientGuidRepo) {
        this.patientNoteRepo = patientNoteRepo;
        this.patientProfileRepository = patientProfileRepository;
        this.clientGuidRepo = clientGuidRepo;
    }

    public static void main(String[] args) {
        SpringApplication.run(NewSystemApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


        PatientProfileEntity patientProfileEntity4 = new PatientProfileEntity("name6", "last_name6", 210);
        Optional<PatientProfileEntity> patientProfileEntity = patientProfileRepository.findById(Long.valueOf(1));
        ClientGuidEntity clientGuidEntity1 = new ClientGuidEntity(2L, patientProfileEntity.get());
        ClientGuidEntity clientGuidEntity2 = new ClientGuidEntity(4L, patientProfileEntity4);
//        Optional<PatientProfileEntity> patientProfileEntity = patientProfileRepository.findById(Long.valueOf(1));
//        patientProfileRepository.save(patientProfileEntity4);
//        clientGuidRepo.save(clientGuidEntity1);
    }
}
