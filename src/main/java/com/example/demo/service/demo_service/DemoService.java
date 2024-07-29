package com.example.demo.service.demo_service;

import java.util.List;
import java.util.Optional;

import com.example.demo.dto.request.PostDemoRequest;
import com.example.demo.dto.request.UpdateDemoRequest;
import com.example.demo.entity.Demo;

/**
 * DemoService
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
public interface DemoService {
    List<Demo> findAll();
    Optional<Demo> findById(Long id);
    Demo save(PostDemoRequest postDemoRequest);
    Demo update(Demo demo, UpdateDemoRequest updateDemoRequest);
    void deleteById(Long id);
}
