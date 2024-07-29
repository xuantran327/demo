package com.example.demo.service.demo_service;

import com.example.demo.dto.request.UpdateDemoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.example.demo.dto.request.PostDemoRequest;
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
public class DemoServiceImpl implements DemoService {
    @Autowired
    private DemoRepository demoRepository;

    @Autowired
    private DemoMapper demoMapper;

    /** get list of demo from database
     * @return List<Demo>
     */
    @Override
    public List<Demo> findAll() {
        return demoRepository.findAll();
    }

    /** get demo by id from database
     * @param id
     * @return Optional<Demo>
     */
    @Override
    public Optional<Demo> findById(Long id) {
        return demoRepository.findById(id);
    }

    /** save demo to database
     * @param postDemoRequest
     * @return Demo
     */
    @Override
    public Demo save(PostDemoRequest postDemoRequest) {
        return demoRepository.save(demoMapper.fromPostDemoRequest(postDemoRequest));
    }

    /**
     * update demo to database
     * @param demo
     * @param updateDemoRequest
     * @return
     */
    @Override
    public Demo update(Demo demo, UpdateDemoRequest updateDemoRequest) {
        return demoRepository.save(demoMapper.updateDemoFromRequest(demo, updateDemoRequest));
    }

    /** delete demo from database
     * @param id
     */
    @Override
    public void deleteById(Long id) {
        demoRepository.deleteById(id);
    }
}
