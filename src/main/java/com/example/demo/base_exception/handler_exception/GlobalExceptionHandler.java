package com.example.demo.base_exception.handler_exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.*;

import com.example.demo.base_exception.ApiException;
import com.example.demo.dto.response.ApiResponse;

/**
 * GlobalExceptionHandler
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
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * handle api expention
     * @param e
     * @return ResponseEntity
     */
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiResponse> handlerApiException(ApiException e) {
        return ResponseEntity.ok(new ApiResponse(e.getCode(), e.getMessage(), null));
    }

    /**
     * handle bind exception
     * @param e
     * @return ResponseEntity
     */
    @ExceptionHandler(BindException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiResponse> handlerBindException(BindException e) {
        String errorMessage = "Invalid request!";
        if (e.getBindingResult().hasErrors()) {
            errorMessage = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        }
        return ResponseEntity.ok().body(new ApiResponse(400, errorMessage, null));

    }
}
