package com.example.demo.dto.request;

import jakarta.validation.constraints.NotEmpty;

/**
 * UpdateDemoRequest
 *
 * Version 1.0
 *
 * Date: 29-07-2024
 *
 * Copyright
 *
 * Modification Logs:
 * DATE             AUTHOR          DESCRIPTION
 * ---------------------------------------------------------
 * 29-07-2024       XuanTTX         Create
 */
public record UpdateDemoRequest(@NotEmpty(message = "Name must not be empty") String name) {
}
