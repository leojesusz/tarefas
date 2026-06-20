package com.leonardo.tarefas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ApiError> handleNotFound(NoSuchElementException ex) {
        ApiError error = new ApiError(LocalDateTime.now(), 404, "Not Found", "Tarefa não encontrada", "/tarefas");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}