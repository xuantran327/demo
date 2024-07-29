package com.example.demo.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.example.demo.base_exception.ApiException;
import com.example.demo.dto.request.PostDemoRequest;
import com.example.demo.dto.request.UpdateDemoRequest;
import com.example.demo.dto.response.ApiResponse;
import com.example.demo.entity.Demo;
import com.example.demo.repository.DemoRepository;
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
@RestController
@RequestMapping(value = "/demo")
@RequiredArgsConstructor
public class DemoController {
    @Autowired
    private DemoServiceImpl demoService;

    @Autowired
    private DemoRepository demoRepository;

    @GetMapping("/data")
    public ResponseEntity<ApiResponse> findAll() {
        List<Demo> list = demoService.findAll();
        if (list.isEmpty()) {
            throw new ApiException(404, "No demos found");
        }
        return ResponseEntity.ok(new ApiResponse(200 , "OK", list));
    }

    @GetMapping("/data/{id}")
    public ResponseEntity<ApiResponse> findById(@PathVariable("id") Long id) {
        Demo demo = demoService.findById(id)
                .orElseThrow(() -> new ApiException(404, "No demo found for id: " + id));
        return ResponseEntity.ok(new ApiResponse(200 , "OK", demo));
    }

    @GetMapping("/search/{keyword}")
    public ResponseEntity<ApiResponse> findByNameContaining(@PathVariable("keyword") String keyword) {
        List<Demo> list = demoRepository.findByNameContaining(keyword);
        if (list.isEmpty()) {
            throw new ApiException(404, "No demos found for keyword: " + keyword);
        }
        return ResponseEntity.ok(new ApiResponse(200 , "OK", list));
    }

    @PostMapping("/save")
    public ResponseEntity<ApiResponse> save(@Valid @RequestBody PostDemoRequest postDemoRequest) {
        try {
            Demo demo = demoService.save(postDemoRequest);
            return ResponseEntity.ok(new ApiResponse(200, "OK", demo));
        } catch (Exception e) {
            throw new ApiException(400, "Could not save demo: " + postDemoRequest.toString() + " to database");
        }
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<ApiResponse> update(@PathVariable("id") Long id, @Valid @RequestBody UpdateDemoRequest updateDemoRequest) {
        try {
            Demo demo = demoService.findById(id)
                    .orElseThrow(() -> new ApiException(404, "No demo found for id: " + id));
            demoService.update(demo, updateDemoRequest);
            return ResponseEntity.ok(new ApiResponse(200, "OK", demo));
        } catch (Exception e) {
            throw new ApiException(400, "Could not update demo: " + updateDemoRequest.toString() + " to database");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteById(@PathVariable("id") Long id) {
        try {
            demoService.findById(id)
                    .orElseThrow(() -> new ApiException(404, "No demo found for id: " + id));
            demoService.deleteById(id);
            return ResponseEntity.ok(new ApiResponse(200, "Deleted successfully", null));
        } catch (Exception e) {
            throw new ApiException(400, "Deleted failed");
        }
    }
}
