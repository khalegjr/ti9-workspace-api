package br.com.ti9.ti9workspaceapi.controller.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.ti9.ti9workspaceapi.service.execption.*;

import java.time.LocalDateTime;

@ControllerAdvice
public class ResourceExceptionHandler {

  @ExceptionHandler(AuthenticationException.class)
  public ResponseEntity<StandardError> authentication(AuthenticationException e, HttpServletRequest request) {
    StandardError error = new StandardError(LocalDateTime.now(), HttpStatus.UNAUTHORIZED.value(), "Unauthorized", e.getMessage(), request.getRequestURI());
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
  }

  @ExceptionHandler(AuthorizationException.class)
  public ResponseEntity<StandardError> authorization(AuthorizationException e, HttpServletRequest request) {
    StandardError error = new StandardError(LocalDateTime.now(), HttpStatus.FORBIDDEN.value(), "Forbidden", e.getMessage(), request.getRequestURI());
    return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error);
  }

  @ExceptionHandler(DataNotFoundException.class)
  public ResponseEntity<StandardError> dataNotFound(DataNotFoundException e, HttpServletRequest request) {
    StandardError error = new StandardError(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), "Data not found", e.getMessage(), request.getRequestURI());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
  }

  @ExceptionHandler(AlreadyExistsException.class)
  public ResponseEntity<StandardError> alreadyExists(AlreadyExistsException e, HttpServletRequest request) {
    StandardError error = new StandardError(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), "Already exists", e.getMessage(), request.getRequestURI());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
  }

  @ExceptionHandler(FileException.class)
  public ResponseEntity<StandardError> file(FileException e, HttpServletRequest request) {
    StandardError error = new StandardError(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), "File error", e.getMessage(), request.getRequestURI());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
  }

  @ExceptionHandler(EmailException.class)
  public ResponseEntity<StandardError> email(EmailException e, HttpServletRequest request) {
    StandardError error = new StandardError(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), "E-mail error", e.getMessage(), request.getRequestURI());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
  }

  @ExceptionHandler(ValidationException.class)
  public ResponseEntity<StandardError> validation(ValidationException e, HttpServletRequest request) {
    StandardError error = new StandardError(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), "Validation error", e.getMessage(), request.getRequestURI());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<StandardError> argumentValidation(MethodArgumentNotValidException e, HttpServletRequest request) {
    ValidationError error = new ValidationError(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), "Argument validation error", null, request.getRequestURI());
    for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
      error.addError(fieldError.getField(), fieldError.getDefaultMessage());
    }
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
  }

  @ExceptionHandler(MissingServletRequestParameterException.class)
  public ResponseEntity<StandardError> requestParameterValidation(MissingServletRequestParameterException e, HttpServletRequest request) {
    StandardError error = new StandardError(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), "Request parameter validation error", e.getMessage(), request.getRequestURI());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
  }

}
