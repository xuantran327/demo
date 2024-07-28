package com.example.demo.base_exception;

import lombok.*;

import java.io.Serial;

/**
 * ApiException
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
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;
    private Integer code;
    private String message;
}
