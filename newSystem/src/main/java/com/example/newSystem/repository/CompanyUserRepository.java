package com.example.newSystem.repository;

import com.example.newSystem.entity.CompanyUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyUserRepository extends JpaRepository<CompanyUserEntity, Long> {
    public CompanyUserEntity findByLogin(String login);
}
