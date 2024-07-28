package com.example.demo.service.demo_service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.base_exception.ApiException;
import com.example.demo.dto.request.PostDemoRequest;
import com.example.demo.dto.response.ApiResponse;
import com.example.demo.entity.Demo;
import com.example.demo.mapper.DemoMapper;
import com.example.demo.repository.DemoRepository;

/**
 * DemoServiceImpl
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
@Service
@RequiredArgsConstructor
@Slf4j
public class DemoServiceImpl implements DemoService {

    @Autowired
    private DemoRepository demoRepository;

    @Autowired
    private DemoMapper demoMapper;

    /**
     * get demo from database
     * @param id
     * @return ApiResponse
     */
    public ApiResponse findById(Long id) {
        Demo test = demoRepository.findById(id).orElseThrow(() -> new ApiException(404, "Could not find demo for id: " + id));
        return new ApiResponse(200 , "OK", test);
    }

    /**
     * save demo to database
     * @param postDemoRequest
     * @return ApiException
     */
    public ApiResponse save(PostDemoRequest postDemoRequest) {
        try {
            Demo demo = demoRepository.save(demoMapper.fromAddTestRequest(postDemoRequest));
            return new ApiResponse(200 , "OK", demo);

        }catch (Exception e) {
            log.error(e.getMessage());
            throw new ApiException(400, "Could not save demo: " + postDemoRequest.toString() + " to database");

        }
    }

    /**
     * delete demo
     * @param id
     * @return ApiException
     */
    public ApiResponse deleteById(Long id) {
        try {
            Demo demo = demoRepository.findById(id).orElseThrow(() -> new ApiException(404, "could not find test for id: " + id));
            demoRepository.delete(demo);
            return new ApiResponse(200, "delete successfully", null);
        }catch (Exception e) {
            log.error(e.getMessage());
            throw new ApiException(400, " deleting test failed");
        }
    }
}
