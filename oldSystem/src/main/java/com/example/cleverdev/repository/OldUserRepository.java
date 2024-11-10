package com.example.cleverdev.repository;

import com.example.cleverdev.entity.OldCompanyUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OldUserRepository extends JpaRepository<OldCompanyUserEntity,Long> {
}
