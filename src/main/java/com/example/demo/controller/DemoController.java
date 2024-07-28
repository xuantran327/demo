package com.example.demo.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.request.PostDemoRequest;
import com.example.demo.dto.response.ApiResponse;
import com.example.demo.service.demo_service.DemoServiceImpl;

/**
 * DemoController
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
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping(value = "/demo")
@RequiredArgsConstructor
public class DemoController {
    
    @Autowired
    private DemoServiceImpl demoService;

    @GetMapping("/data/{id}")
    public ResponseEntity<ApiResponse> findById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(demoService.findById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<ApiResponse> saveTest(@Valid @RequestBody PostDemoRequest postDemoRequest) {
        return ResponseEntity.ok(demoService.save(postDemoRequest));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(demoService.deleteById(id));
    }
}
