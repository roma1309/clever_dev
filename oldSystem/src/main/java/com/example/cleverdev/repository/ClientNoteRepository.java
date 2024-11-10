package com.example.cleverdev.repository;

import com.example.cleverdev.entity.ClientNoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ClientNoteRepository extends JpaRepository<ClientNoteEntity, Long> {

    @Query(value = "Select client_note.id, client_note.created_date_time, client_note.last_modified_date_time,\n" +
            "client_note.comment, client_note.fk_pat_note_to_client, client_note.last_modified_by_u, client_note.created_by_user_id\n" +
            "  from client_note, client_profile where" +
            " client_note.fk_pat_note_to_client =:clientGuid" +
            " and client_profile.agency =:agency ",
            nativeQuery = true)
    public List<ClientNoteEntity> searchNotes(@Param("agency") String agency, @Param("clientGuid") Long clientGuid);
}
