package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * Demo
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
@Entity
@Table(name = "_demo")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@EntityListeners(AuditingEntityListener.class)
public class Demo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "[id]")
    private Long id;

    @Column(name = "[name]")
    private String name;

    @CreatedDate
    @Column(name = "[created_at]", updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "[updated_at]")
    private LocalDateTime updatedAt;
}
