package com.example.demo.repository;

import com.example.demo.entity.Demo;
import org.springframework.data.jpa.repository.JpaRepository;

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
public interface DemoRepository extends JpaRepository<Demo, Long> {
}
