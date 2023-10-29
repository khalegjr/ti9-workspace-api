package br.com.ti9.ti9workspaceapi.controller.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

  private List<FieldMessage> errors = new ArrayList<>();

  public ValidationError(LocalDateTime dateTime, Integer status, String error, String message, String path) {
    super(dateTime, status, error, message, path);
  }

  public List<FieldMessage> getErrors() {
    return errors;
  }

  public void addError(String fieldName, String message) {
    errors.add(new FieldMessage(fieldName, message));
  }

}
