package com.igor.bajobs.bajobs.handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.igor.bajobs.bajobs.exception.JobNotFoundException;
import com.igor.bajobs.bajobs.handler.domain.ErrorResponse;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
//        return super.handleMethodArgumentNotValid(ex, headers, status, request);
//    }

    @ExceptionHandler(JobNotFoundException.class)
    public ResponseEntity<Object> handleExistingJob(JobNotFoundException ex, WebRequest request) {
        HttpStatusCode status = HttpStatus.NOT_FOUND;
        ErrorResponse body = new ErrorResponse(LocalDateTime.now(), status.value(), ex.getClass().getSimpleName(), ex.getMessage());
//        return new ResponseEntity<>(body, status);
        return handleExceptionInternal(ex, body, new HttpHeaders(), status, request);
    }
}
