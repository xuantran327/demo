package com.example.demo.mapper;

import org.springframework.stereotype.Component;

import com.example.demo.dto.request.PostDemoRequest;
import com.example.demo.entity.Demo;

/**
 * DemoMapper
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
@Component
public class DemoMapper {

    /**
     * convert postDemoRequest to Test
     * @param postDemoRequest
     * @return Demo
     */
    public Demo fromAddTestRequest(PostDemoRequest postDemoRequest) {
        return Demo.builder()
                .name(postDemoRequest.name())
                .build();
    }
}
