package com.example.newSystem.repository;

import com.example.newSystem.entity.ClientGuidEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientGuidRepository extends JpaRepository<ClientGuidEntity, Long> {
    @Query(value = "Select *from old_client_id where client_id =:clientId",
            nativeQuery = true)
    public List<ClientGuidEntity> findByClientId(@Param("clientId")Long clientId);
}
