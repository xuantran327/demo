package com.example.demo.service.demo_service;

import com.example.demo.dto.request.PostDemoRequest;
import com.example.demo.dto.response.ApiResponse;

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
    ApiResponse findById(Long id);
    ApiResponse save(PostDemoRequest postDemoRequest);
    ApiResponse deleteById(Long id);
}
