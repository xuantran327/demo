package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.example.demo.entity.Demo;

/**
 * DemoRepository
 *
 * Version 1.0
 *
 * Date: 26-07-2024
 *
 * Copyright
 *
 * Modification Logs:
 * DATE             AUTHOR          DESCRIPTION
 * ---------------------------------------------------------
 * 26-07-2024       XuanTTX         Create
 */
@Repository
public interface DemoRepository extends JpaRepository<Demo, Long> {
    @Query("SELECT d FROM Demo d WHERE d.name LIKE %:keyword%")
    List<Demo> findByNameContaining(String keyword);
}
