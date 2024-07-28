package com.example.demo.dto.request;

import jakarta.validation.constraints.NotEmpty;

/**
 * PostDemoRequest
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
public record PostDemoRequest(@NotEmpty(message = "Name must not be empty") String name) {
}
