package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.domain.Suplemento;


public interface SuplementoRepository extends JpaRepository<Suplemento, Long> {
    @Query("SELECT s FROM Suplemento s WHERE s.deletedAt IS NULL ORDER BY s.id")
    List<Suplemento> findAllWhereIsDeletedIsNotNull();
}